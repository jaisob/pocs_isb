DROP SCHEMA IF EXISTS test CASCADE;

CREATE SCHEMA test;

CREATE TABLE test.agent
(
  id serial NOT NULL PRIMARY KEY,
  agent character varying,
  place_id character varying
);

CREATE TABLE test.canal
(
  id serial NOT NULL PRIMARY KEY,
  logicalname character varying(255) NOT NULL UNIQUE,
  maximo integer,
  medio character varying
);

CREATE TABLE test.entity
(
  id serial NOT NULL PRIMARY KEY,
  logicalname character varying(255) NOT NULL UNIQUE,
  entity_name character varying(255) NOT NULL
);

CREATE TABLE test.entity_canal
(
  id serial NOT NULL PRIMARY KEY,
  entity_id integer NOT NULL,
  canal_id integer NOT NULL,
  CONSTRAINT "entity_canal_canalid_fk" FOREIGN KEY (entity_id)
      REFERENCES test.entity (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE RESTRICT,
  CONSTRAINT "entity_canal_entityid_fk" FOREIGN KEY (canal_id)
      REFERENCES test.canal (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE RESTRICT
);

CREATE TABLE test.filter
(
  id serial NOT NULL PRIMARY KEY,
  logicalname character varying(255) NOT NULL UNIQUE,
  definition character varying(500),
  handler_type character varying(100),
  status character varying(100),
  reason character varying(100),
  filter_type character varying(100)
);

CREATE TABLE test.action
(
  id serial NOT NULL PRIMARY KEY,
  logicalname character varying(255) NOT NULL UNIQUE,
  definition character varying(2000)
);

CREATE TABLE test.filter_action
(
  id serial NOT NULL PRIMARY KEY,
  filter_name integer,
  action_name integer,
  CONSTRAINT c_filter_action_fk01 FOREIGN KEY (filter_name)
      REFERENCES test.filter (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE RESTRICT,
  CONSTRAINT c_filter_action_fk02 FOREIGN KEY (action_name)
      REFERENCES test.action (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE RESTRICT
);
