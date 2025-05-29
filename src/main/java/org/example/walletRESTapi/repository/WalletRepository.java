package org.example.walletRESTapi.repository;

import org.example.walletRESTapi.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {

}
