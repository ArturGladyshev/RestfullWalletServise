package org.example.walletRESTapi;

import org.example.walletRESTapi.entity.Wallet;
import org.example.walletRESTapi.repository.WalletDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class DatabaseInstaller {

    @Bean
    CommandLineRunner initDatabase(WalletDao walletDao) {
        return args -> {
            walletDao.create(new Wallet("Saske", new BigDecimal(500)));
            walletDao.create(new Wallet("Kenshi", new BigDecimal(11111.0001)));
            walletDao.create(new Wallet("Yske", new BigDecimal(66600)));
            walletDao.create(new Wallet("Sayori", new BigDecimal(222.002)));
        };
    }

}
