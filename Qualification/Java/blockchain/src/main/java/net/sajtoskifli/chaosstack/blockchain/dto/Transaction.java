package net.sajtoskifli.chaosstack.blockchain.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Transaction
 */
public class Transaction {
    
    @SerializedName("tx_hash")
    private String txHash;

    private String sender;

    private String recipient;

    private String amount;

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @return the recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @return the txHash
     */
    public String getTxHash() {
        return txHash;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @param recipient the recipient to set
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @param txHash the txHash to set
     */
    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

}