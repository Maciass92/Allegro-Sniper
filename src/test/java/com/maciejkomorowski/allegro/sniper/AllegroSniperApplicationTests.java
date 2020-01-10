package com.maciejkomorowski.allegro.sniper;

import com.maciejkomorowski.allegro.sniper.controllers.AllegroAuthController;
import com.maciejkomorowski.allegro.sniper.controllers.AuctionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllegroSniperApplicationTests {

	@Autowired
	private AllegroAuthController allegroAuthController;
	@Autowired
	private AuctionController auctionController;

	@Test
	public void contextLoads() {
		assertThat(allegroAuthController).isNotNull();
		assertThat(auctionController).isNotNull();
	}

}
