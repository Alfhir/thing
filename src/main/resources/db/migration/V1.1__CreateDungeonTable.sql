-- V1.1__CreateDungeonTable.sql

-- Create the schema if it doesn't exist
CREATE SCHEMA IF NOT EXISTS dungeon;

-- Drop all existing tables while testing to have clean state--
drop table if exists dungeon.language;

-- Create the "dungeon" table
CREATE TABLE dungeon.dungeon
(
    id SERIAL PRIMARY KEY
);
