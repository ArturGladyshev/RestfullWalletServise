package org.example.walletRESTapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "wallets")
@Getter
@Setter
public class Wallet {

 @Id
 private String uuid = UUID.randomUUID().toString();

 @Column(nullable = false)
 private String name;

 @Column(nullable = false)
 private BigDecimal balance;

 public Wallet() {
 }

 public Wallet(String uuid, String name, BigDecimal balance) {
  this.uuid = uuid;
  this.name = name;
  this.balance = balance;
 }

 public Wallet(String name, BigDecimal balance) {
  this.name = name;
  this.balance = balance;
 }

 @Override
 public String toString() {
  return "Wallet{" +
          "uuid='" + uuid + '\'' +
          ", name='" + name + '\'' +
          ", balance=" + balance +
          '}';
 }

}
