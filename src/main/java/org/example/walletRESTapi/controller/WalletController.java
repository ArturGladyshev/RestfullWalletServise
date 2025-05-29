package org.example.walletRESTapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.walletRESTapi.controller.request.OperationRequest;
import org.example.walletRESTapi.entity.Wallet;
import org.example.walletRESTapi.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/wallets/{uuid}")
    ResponseEntity<Wallet> getWalletById(@PathVariable String uuid) {
        return ResponseEntity.ok(walletService.getWalletById(uuid));
    }

    @GetMapping("/wallets")
    ResponseEntity<List<Wallet>> getAllWallets() {
        return ResponseEntity.ok(walletService.getAllWallets());
    }

    @PutMapping("/wallets")
    ResponseEntity<Wallet> changeBalance(@RequestBody OperationRequest request) {
        return ResponseEntity.ok(walletService.changeBalance(request));
    }

    @PostMapping("/wallets")
    ResponseEntity<Wallet> addWallet(@RequestBody Wallet wallet) {
        return ResponseEntity.ok(walletService.addWallet(wallet));
    }

    @DeleteMapping("/wallets")
    ResponseEntity<?> DeleteWallet(@RequestBody Wallet wallet) {
        walletService.deleteWallet(wallet);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/wallets/{uuid}")
    ResponseEntity<?> DeleteWalletById(@PathVariable String uuid) {
        walletService.deleteWalletById(uuid);
        return ResponseEntity.ok().build();
    }

}