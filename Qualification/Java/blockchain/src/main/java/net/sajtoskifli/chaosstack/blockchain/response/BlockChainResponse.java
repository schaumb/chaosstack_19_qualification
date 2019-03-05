package net.sajtoskifli.chaosstack.blockchain.response;

import java.util.List;

import net.sajtoskifli.chaosstack.blockchain.dto.Block;

/**
 * BlockChainResponse
 */
public class BlockChainResponse {

    private Boolean completed;
    private List<Block> blocks;

    /**
     * @return the completed
     */
    public Boolean getCompleted() {
        return completed;
    }

    /**
     * @return the blocks
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * @param blocks the blocks to set
     */
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}