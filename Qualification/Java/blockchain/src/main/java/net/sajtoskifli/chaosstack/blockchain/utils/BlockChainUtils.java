package net.sajtoskifli.chaosstack.blockchain.utils;

import java.util.StringJoiner;

import org.apache.commons.codec.digest.DigestUtils;

import net.sajtoskifli.chaosstack.blockchain.dto.Block;
import net.sajtoskifli.chaosstack.blockchain.dto.Transaction;

/**
 * BlockChainUtils
 */
public class BlockChainUtils {

    private BlockChainUtils() {
    }

    public static String calculateBlockHash(Block block) {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(block.getPrevBlock());
        joiner.add(block.getNonce().toString());
        for (Transaction t : block.getTransactions()) {
            joiner.add(t.getTxHash());
        }
        return DigestUtils.sha1Hex(joiner.toString());
    }

}