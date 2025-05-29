package org.example.walletRESTapi.repository;

import lombok.RequiredArgsConstructor;
import org.example.walletRESTapi.entity.Wallet;
import org.example.walletRESTapi.exception.IllegalInputException;
import org.example.walletRESTapi.exception.InputErrorType;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WalletDao extends AbstractDao<Wallet> {

    private final WalletRepository walletRepository;

    @Override
    public Wallet getById(String uuid) {
        Optional<Wallet> walletOptional = walletRepository.findById(uuid);
        if (walletOptional.isEmpty()) {
            throw new IllegalInputException(InputErrorType.ID_NOT_FOUND, uuid);
        }
        return walletOptional.get();
    }

    @Override
    public List<Wallet> getAll() {
        List<Wallet> walletList = walletRepository.findAll();
        if (walletList.isEmpty()) {
            throw new IllegalInputException(InputErrorType.DATABASE_EMPTY);
        }
        return walletList;
    }

    @Override
    public Wallet create(Wallet wallet) {
        walletRepository.save(wallet);
        return this.getById(wallet.getUuid());
    }

    @Override
    public Wallet update(Wallet wallet) {
        if (!walletRepository.existsById(wallet.getUuid())) {
            throw new IllegalInputException(InputErrorType.ID_NOT_EXISTS, wallet.getUuid());
        }
        walletRepository.save(wallet);
        return this.getById(wallet.getUuid());
    }

    @Override
    public void delete(Wallet wallet) {
        if (!walletRepository.existsById(wallet.getUuid())) {
            throw new IllegalInputException(InputErrorType.ID_NOT_EXISTS, wallet.getUuid());
        }
        walletRepository.delete(wallet);
    }

    @Override
    public void deleteById(String uuid) {
        if (!walletRepository.existsById(uuid)) {
            throw new IllegalInputException(InputErrorType.ID_NOT_EXISTS, uuid);
        }
        walletRepository.deleteById(uuid);
    }

}


