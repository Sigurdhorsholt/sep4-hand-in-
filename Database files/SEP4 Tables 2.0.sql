


SET SCHEMA 'sep4.solarpanelDatabase';



-- Creating DOMAINS:

CREATE DOMAIN sep4db.panel_type varchar
    CHECK ( VALUE in ('electrical','Thermal'));

CREATE DOMAIN sep4db.measurement_value float
    CHECK ( value >= 0);


-- CREATING TABLES:

CREATE SCHEMA sep4db;
SET SCHEMA  'sep4.sep4db';

CREATE  TABLE sep4db.testtesttest(
    test1 int,
    test2 int
);

-- manufacturer
CREATE TABLE sep4db.manufacturer(
    name varchar primary key
);


-- Contact info
CREATE TABLE sep4db.contact_info(
    time_add timestamp primary key,
    name varchar,
    phone_no varchar CHECK (phone_no ~ '^[0-9]{10}$'),
    email varchar CHECK (email ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'),
    FOREIGN KEY (name) references sep4db.manufacturer(name)
);




-- model
CREATE TABLE sep4db.model(
    model_no varchar primary key,
    manufacturer varchar,
    type_ sep4db.panel_type,

    FOREIGN KEY (manufacturer) references sep4db.manufacturer(name)
);


-- solar_panels

CREATE TABLE sep4db.solar_panel(
    panel_id serial primary key,
    installation_date DATE NOT NULL ,
    model_no varchar(20) NOT NULL,
    Foreign Key (model_no) references sep4db.model(model_no)
);

-- active_panel
CREATE TABLE sep4db.active_panel(
      panel_id int primary key ,
      row_ int,
      column_ int,
      FOREIGN KEY (panel_id) REFERENCES sep4db.solar_panel(panel_id)
);

-- retired_panel
CREATE TABLE sep4db.retired_panel(
      panel_id int PRIMARY KEY,
      row_ int,
      column_ int,
      date_removed DATE,
    FOREIGN KEY (panel_id) REFERENCES sep4db.solar_panel(panel_id)
);


-- Electrical_measurement
CREATE TABLE sep4db.electrical_measurement(
    time_ timestamp,
    panel_id int,
    value_ sep4db.measurement_value,
    power_input sep4db.measurement_value,
    PRIMARY KEY(time_, panel_id),
    FOREIGN KEY(panel_id) REFERENCES sep4db.solar_panel(panel_id)
);

-- thermal_measurement
CREATE TABLE sep4db.thermal_measurement(
    time_ timestamp,
    panel_id int,
    value_ sep4db.measurement_value,
    power_input sep4db.measurement_value,
    PRIMARY KEY(time_, panel_id),
    FOREIGN KEY(panel_id) REFERENCES sep4db.solar_panel(panel_id)
);




-- ENSURING DISJOINT BETWEEN ACTIVE AND RETRIED PANEL TABLES:

/*
 This will work by adding 2 triggers.
    The first trigger will be called whenever a insert statement
    is made on Active_panel.
    It checks if the "panel" inserted is present in Retired_panel before posting
    IF the "panel" exists in retired then i raises exception...

    The second trigger is the exact same just in reverse.


 */


CREATE OR REPLACE FUNCTION sep4db.check_disjoint_panels()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM sep4db.retired_panel WHERE panel_id = NEW.panel_id) THEN
        RAISE EXCEPTION 'Panel is already retired';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER active_panel_insert_trigger
BEFORE INSERT ON sep4db.active_panel
FOR EACH ROW EXECUTE FUNCTION sep4db.check_disjoint_panels();



CREATE OR REPLACE FUNCTION sep4db.check_disjoint_panels_retired()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM sep4db.active_panel WHERE panel_id = NEW.panel_id) THEN
        RAISE EXCEPTION 'Panel is still active';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER retired_panel_insert_trigger
BEFORE INSERT ON sep4db.retired_panel
FOR EACH ROW EXECUTE FUNCTION sep4db.check_disjoint_panels_retired();




-- CREATE FUNCTION THAT REMOVES A PANEL FROM ACTIVE AND COPIES IT TO RETIRED
CREATE OR REPLACE FUNCTION sep4db.move_panel_to_retired(p_id INT, removal_date DATE)
RETURNS VOID AS $$
BEGIN
    -- First, check if the panel exists in the active_panel table
    IF EXISTS (SELECT 1 FROM sep4db.active_panel WHERE panel_id = p_id) THEN
        -- If it exists, insert the relevant information into the retired_panel table
        INSERT INTO sep4db.retired_panel(panel_id, row_, column_, date_removed)
        SELECT panel_id, row_, column_, removal_date FROM sep4db.active_panel WHERE panel_id = p_id;

        -- Then, remove the panel from the active_panel table
        DELETE FROM sep4db.active_panel WHERE panel_id = p_id;
    ELSE
        RAISE NOTICE 'Panel with id % does not exist in active panels', p_id;
    END IF;
END;
$$ LANGUAGE plpgsql;



-- COPY THIS STATEMENT WHEN WANTING TO MOVE A PANEL
-- YOU NEED TO REPLACE <panel_id>, <removal_date> FOR IT TO WORK!
--SELECT move_panel_to_retired(<panel_id>, <removal_date>);
-- retired_panel
CREATE TABLE dataTable2(
      panel_id int PRIMARY KEY,
      row_ int,
      column_ int,
      date_removed DATE,
    FOREIGN KEY (panel_id) REFERENCES sep4db.solar_panel(panel_id)
);