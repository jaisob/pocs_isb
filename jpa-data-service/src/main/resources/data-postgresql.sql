INSERT INTO test.agent (agent,place_id) VALUES ('user14', 'Place3001111');
INSERT INTO test.agent (agent,place_id) VALUES ('user15', 'Place3001112');

INSERT INTO test.canal (logicalname,maximo,medio) VALUES ('CALL', 1, 'LL');
INSERT INTO test.canal (logicalname,maximo,medio) VALUES ('CHAT', 2, 'CH');
INSERT INTO test.canal (logicalname,maximo,medio) VALUES ('EMAIL', 5, 'EM');

INSERT INTO test.entity (logicalname,entity_name) VALUES ('Santander', 'San');
INSERT INTO test.entity (logicalname,entity_name) VALUES ('Totta', 'Tot');
INSERT INTO test.entity (logicalname,entity_name) VALUES ('Openbank', 'Open');

INSERT INTO test.entity_canal (entity_id,canal_id) VALUES (1, 1);
INSERT INTO test.entity_canal (entity_id,canal_id) VALUES (1, 2);
INSERT INTO test.entity_canal (entity_id,canal_id) VALUES (2, 2);
INSERT INTO test.entity_canal (entity_id,canal_id) VALUES (3, 3);

INSERT INTO test.filter (logicalname,definition,handler_type,status,reason,filter_type) VALUES ('Filter1', 'def_filter_1', 'INTERACTION_VOICE', 'IDLE', 'RELEASED', 'PHONECALL');
INSERT INTO test.filter (logicalname,definition,handler_type,status,reason,filter_type) VALUES ('Filter2', 'def_filter_2', 'INTERACTION_VOICE', 'IDLE', 'RELEASED', 'PHONECALL');
INSERT INTO test.filter (logicalname,definition,handler_type,status,reason,filter_type) VALUES ('Filter3', 'def_filter_3', 'INTERACTION_VOICE', 'IDLE', 'RELEASED', 'PHONECALL');
INSERT INTO test.filter (logicalname,definition,handler_type,status,reason,filter_type) VALUES ('Filter4', 'def_filter_4', 'INTERACTION_VOICE', 'IDLE', 'RELEASED', 'PHONECALL');
INSERT INTO test.filter (logicalname,definition,handler_type,status,reason,filter_type) VALUES ('Filter5', 'def_filter_5', 'INTERACTION_VOICE', 'NEW', 'NEW', 'PHONECALL');

INSERT INTO test.action (logicalname,definition) VALUES ('Action_1', 'def_action_1');
INSERT INTO test.action (logicalname,definition) VALUES ('Action_2', 'def_action_2');
INSERT INTO test.action (logicalname,definition) VALUES ('Action_3', 'def_action_3');
INSERT INTO test.action (logicalname,definition) VALUES ('Action_4', 'def_action_4');

INSERT INTO test.filter_action (filter_name,action_name) VALUES (1, 1);
INSERT INTO test.filter_action (filter_name,action_name) VALUES (1, 2);
INSERT INTO test.filter_action (filter_name,action_name) VALUES (2, 2);
INSERT INTO test.filter_action (filter_name,action_name) VALUES (3, 3);
INSERT INTO test.filter_action (filter_name,action_name) VALUES (4, 4);
INSERT INTO test.filter_action (filter_name,action_name) VALUES (5, 2);
