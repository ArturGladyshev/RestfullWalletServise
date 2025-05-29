package org.example.walletRESTapi.service;

import lombok.RequiredArgsConstructor;
import org.example.walletRESTapi.controller.request.OperationRequest;
import org.example.walletRESTapi.controller.request.OperationType;
import org.example.walletRESTapi.entity.Wallet;
import org.example.walletRESTapi.exception.IllegalInputException;
import org.example.walletRESTapi.exception.InputErrorType;
import org.example.walletRESTapi.repository.WalletDao;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletDao walletDao;

    public Wallet getWalletById(String uuid) {
        return walletDao.getById(uuid);
    }

    public List<Wallet> getAllWallets() {
        return walletDao.getAll();
    }

    public Wallet addWallet(Wallet wallet) {
        return walletDao.create(wallet);
    }

    public void deleteWallet(Wallet wallet) {
        walletDao.delete(wallet);
    }

    public void deleteWalletById(String uuid) {
        walletDao.deleteById(uuid);
    }

    public Wallet changeBalance(OperationRequest request) {
        if (request.getOperationType().equals(OperationType.DEPOSIT)) {
            return this.depositBalance(request.getUuid(), request.getAmount());
        } else {
            return this.withdrawBalance(request.getUuid(), request.getAmount());
        }
    }

    private Wallet withdrawBalance(String uuid, BigDecimal amount) {
        Wallet wallet = walletDao.getById(uuid);
        if (wallet.getBalance().compareTo(amount) < 0) {
            throw new IllegalInputException(InputErrorType.BALANCE_ENOUGH);
        }
        wallet.setBalance(wallet.getBalance().subtract(amount));
        return walletDao.update(wallet);
    }

    private Wallet depositBalance(String uuid, BigDecimal amount) {
        Wallet wallet = walletDao.getById(uuid);
        wallet.setBalance(wallet.getBalance().add(amount));
        return walletDao.update(wallet);
    }

}
