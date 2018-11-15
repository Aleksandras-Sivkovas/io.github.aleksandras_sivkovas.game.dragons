--items
insert into ITEM 	(name, 		gold,	ability)
	values			('Item1',	2,		1);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item2',	3,		2);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item3',	3,		2);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item4',	2,		1);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item5',	4,		2);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item6',	2,		1);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item7',	3,		2);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item8',	3,		2);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item9',	2,		1);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item10',	20,		50);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item11',	8,		30);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item12',	6,		15);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item13',	3,		2);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item14',	12,		40);
insert into ITEM 	(name, 		gold,	ability)
	values			('Item15',	4,		2);

--games
insert into GAME	(lives,	gold,	score,	turn)
	values			(10,	10,		10,		3);
insert into GAME 	(lives,	gold,	score,	turn)
	values			(10,	10,		100,	10);
insert into GAME 	(lives,	gold,	score,	turn)
	values			(10,	10,		1010,	10);
	
--bought items	
insert into BOUGHT_ITEM	(game_id,	item_id)
	values (2,2);
insert into BOUGHT_ITEM (game_id,item_id)
	values(2,1);

--ads	
insert into AD 	(message,			reward,	appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Find a chicken.',	10,		1,				3,				20,					1);
insert into AD 	(message,			reward,	appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Find a goat.',	20,		1,				3,				30,					1);
insert into AD 	(message,					reward,			appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Find a missing person.',	100,			1,				3,				50,					3);
insert into AD 	(message,		reward,	appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Find a dog.',	30,		1,				3,				2,					1);
insert into AD 	(message,			reward,	appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Find a chicken.',	40,		6,				10,				100,					1);
insert into AD 	(message,			reward,	appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Find a goat.',	50,		5,				6,				80,					1);
insert into AD 	(message,					reward,			appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Find a missing person.',	100,			10,				11,				50,					3);
insert into AD 	(message,		reward,	appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Find a dog.',	60,		1,				3,				20,					1);
insert into AD 	(message,			reward,		appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Hunt a dragon.',	10000,		1,				10,				500,				80);
insert into AD 	(message,			reward,		appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Hunt wolves.',	200,			1,				10,				400,					10);
insert into AD 	(message,							reward,		appear_turn,	expire_turn,	points_for_tasks,	dificulty)
	values		('Hunt wolves. In faraway vilage.',	50,			1,				10,				50,					10);

--completed ads
insert into COMPLETED_AD (game_id, ad_id)
	values (2,2);
insert into COMPLETED_AD (game_id, ad_id)
	values(2,1);
insert into COMPLETED_AD (game_id, ad_id)
	values (1,2);
insert into COMPLETED_AD (game_id, ad_id)
	values(1,1);
insert into COMPLETED_AD (game_id, ad_id)
	values (3,2);


	
	
	