package com.rahul.fullstack.service;

import com.rahul.fullstack.entity.AccountEntity;
import com.rahul.fullstack.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Guarantees Atomicity: Either BOTH updates succeed, or the entire operation rolls back!
    @Transactional(rollbackFor = Exception.class)
    public void transferFunds(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        
        // 1. Debit sender account
        AccountEntity sender = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found"));
        sender.debit(amount);
        accountRepository.save(sender);

        // Simulating an unexpected runtime error mid-transaction
        if (amount.compareTo(new BigDecimal("10000")) > 0) {
            throw new IllegalStateException("Transfer limit exceeded! Transaction rolling back...");
        }

        // 2. Credit receiver account
        AccountEntity receiver = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));
        receiver.credit(amount);
        accountRepository.save(receiver);
    }
}