package net.sajtoskifli.chaosstack.blockchain.request;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * SubmitRequest
 */
public class SubmitRequest implements Serializable{

    private static final long serialVersionUID = 524574528149338570L;

    @SerializedName("correct_hash")
    private String correctedHash;

    /**
     * @return the correctedHash
     */
    public String getCorrectedHash() {
        return correctedHash;
    }

    /**
     * @param correctedHash the correctedHash to set
     */
    public void setCorrectedHash(String correctedHash) {
        this.correctedHash = correctedHash;
    }
}