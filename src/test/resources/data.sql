--games
insert into GAME	(lives,	gold,	score,	turn)
	values			(10,	30,		50,		3);
insert into GAME 	(lives,	gold,	score,	turn)
	values			(10,	25,		50,	5);
insert into GAME 	(lives,	gold,	score,	turn)
	values			(10,	0,		0,		1);
	
--bought items	
insert into BOUGHT_ITEM	(game_id,	item_id)
	values (2,2);
insert into BOUGHT_ITEM (game_id,item_id)
	values(2,1);

--completed ads
insert into COMPLETED_AD (game_id, ad_id)
	values (2,2);
insert into COMPLETED_AD (game_id, ad_id)
	values(2,1);
insert into COMPLETED_AD (game_id, ad_id)
	values (1,2);
insert into COMPLETED_AD (game_id, ad_id)
	values(1,1);



	
	
	