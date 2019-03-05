package net.sajtoskifli.chaosstack.blockchain;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sajtoskifli.chaosstack.blockchain.client.BlockChainClient;
import net.sajtoskifli.chaosstack.blockchain.dto.Block;
import net.sajtoskifli.chaosstack.blockchain.response.BlockChainResponse;
import net.sajtoskifli.chaosstack.blockchain.utils.BlockChainUtils;

@SpringBootApplication
@ComponentScan
@RestController
@EnableCaching
public class BlockchainApplication {

	private static final Logger LOG = LoggerFactory.getLogger(BlockchainApplication.class);

	@Autowired
	private BlockChainClient bcc = new BlockChainClient();

	public static void main(String[] args) {
		SpringApplication.run(BlockchainApplication.class, args);
	}

	/**
	 * @return The first invalid block’s correct hash, as it is calculated by you;
	 *         in case all blocks are valid then an empty string “”
	 */
	private String validateBlocks() {
		BlockChainResponse blocksResponse = getSetOfBlocks();
		Block prevBlock = null;
		for (Block b : blocksResponse.getBlocks()) {
			if (prevBlock != null) {
				String correctBlockHash = BlockChainUtils.calculateBlockHash(b);
				if (!b.getBlockSHA().equals(correctBlockHash)) {
					return correctBlockHash;
				}
			}
			prevBlock = b;
		}
		return "";
	}

	@RequestMapping("/submit_solution")
	private String submitSolution() {
		String correctedBlockHash = validateBlocks();
		return bcc.submitSolution(correctedBlockHash);
	}

	@Cacheable("blocks")
	private BlockChainResponse getSetOfBlocks() {
		return bcc.getSetOfBlocks();
	}

}
