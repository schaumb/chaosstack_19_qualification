package net.sajtoskifli.chaosstack.blockchain.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Block
 */
public class Block {

    /**
     * SHA-1 hash of the block
     */
    @SerializedName("block_sha")
    private String blockSHA;

    /**
     * SHA-1 hash of the previous block in the chain
     */
    @SerializedName("prev_block")
    private String prevBlock;

    /**
     * The counter used to find a small enough block hash
     */
    private Integer nonce;

    /**
     * List of transactions the block includes, each transaction has the fields
     */
    private List<Transaction> transactions;

    /**
     * @return the blockSHA
     */
    public String getBlockSHA() {
        return blockSHA;
    }

    /**
     * @return the nonce
     */
    public Integer getNonce() {
        return nonce;
    }

    /**
     * @return the prevBlock
     */
    public String getPrevBlock() {
        return prevBlock;
    }

    /**
     * @return the transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param blockSHA the blockSHA to set
     */
    public void setBlockSHA(String blockSHA) {
        this.blockSHA = blockSHA;
    }

    /**
     * @param nonce the nonce to set
     */
    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    /**
     * @param prevBlock the prevBlock to set
     */
    public void setPrevBlock(String prevBlock) {
        this.prevBlock = prevBlock;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}