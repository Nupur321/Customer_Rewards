package com.customer.rewards;

import com.customer.rewards.service.impl.RewardsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class RewardsUtil {
    Logger logger = LoggerFactory.getLogger(RewardsUtil.class);

    public int calculateRewardAmountPerTrans(int transactionAmount) {
        logger.debug("Customer Transaction Amount:::" + transactionAmount);

        int rewardAmount = 0;
        if (transactionAmount > 100) {
            rewardAmount = (2 * (transactionAmount - 100) + 50);
        } else if(transactionAmount > 50){
            rewardAmount = transactionAmount - 50;
        }

        logger.debug("Customer Reward Amount:::" + rewardAmount);
        return rewardAmount;
    }
}
