INSERT INTO `lym`.`wallets`
(`wallet_id`,
`balance`)
VALUES
(<{wallet_id: }>,
<{balance: }>);

INSERT INTO `lym`.`users`
(`user_id`,
`email`,
`login`,
`password`,
`amount_of_bets`,
`is_approved`,
`role_id`,
`wallet_id`)
VALUES
(<{user_id: }>,
<{email: }>,
<{login: }>,
<{password: }>,
<{amount_of_bets: 0}>,
<{is_approved: 0}>,
<{role_id: 1}>,
<{wallet_id: }>);

INSERT INTO `lym`.`roles`
(`role_id`,
`role_name`)
VALUES
(<{role_id: }>,
<{role_name: }>);

INSERT INTO `lym`.`races`
(`race_id`,
`title`,
`rounds`,
`details`,
`race_data_id`)
VALUES
(<{race_id: }>,
<{title: }>,
<{rounds: }>,
<{details: }>,
<{race_data_id: }>);

INSERT INTO `lym`.`race_data`
(`race_data_id`,
`date`,
`participant_id`)
VALUES
(<{race_data_id: }>,
<{date: }>,
<{participant_id: 1}>);

INSERT INTO `lym`.`payment_cards`
(`payment_cards_id`,
`balance`,
`card_number`)
VALUES
(<{payment_cards_id: }>,
<{balance: }>,
<{card_number: }>);

INSERT INTO `lym`.`participants`
(`participant_id`,
`horse`,
`weight`,
`jockey`)
VALUES
(<{participant_id: }>,
<{horse: }>,
<{weight: }>,
<{jockey: }>);

INSERT INTO `lym`.`bets`
(`bet_id`,
`type_of_bet`,
`first_multiplier`,
`second_multiplier`,
`race_id`)
VALUES
(<{bet_id: }>,
<{type_of_bet: stopper}>,
<{first_multiplier: }>,
<{second_multiplier: }>,
<{race_id: }>);

INSERT INTO `lym`.`bet_info`
(`bet_info_id`,
`prize`,
`bet_amount`,
`multiplier`,
`bet_status`,
`date`,
`bet_details`,
`user_id`,
`bet_id`)
VALUES
(<{bet_info_id: }>,
<{prize: }>,
<{bet_amount: }>,
<{multiplier: }>,
<{bet_status: Waiting}>,
<{date: }>,
<{bet_details: }>,
<{user_id: }>,
<{bet_id: }>);
