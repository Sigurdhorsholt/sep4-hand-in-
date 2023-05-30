
SET SCHEMA 'sep4.sep4db';

/*

 THIS FILE IS USED TO INSERT DUMMY DATA INTO THE DATABASE
 THE DATA IS GENEREATED THROUGH VARIOUS METHODS AND NAMES, NUMBERS ETC
 ARE FICTITIOUS

 */


 -- Manufacturer data

INSERT INTO sep4.sep4db.manufacturer(name)
VALUES
('SolarTech Solutions'),
('Sunny Energy Inc.'),
('Photonics Power LLC'),
('Helios Dynamics'),
('SunPower Manufacturers'),
('RadiantStar Solar'),
('Quantum Leap Energy'),
('NovaSun Industries'),
('EcoLite Power Co.'),
('Zephyr Solars');



INSERT INTO sep4.sep4db.contact_info (time_add, name, phone_no, email)
VALUES
('2023-05-22 12:00:00', 'SolarTech Solutions', '8001234567', 'contact@solartechsolutions.com'),
('2023-05-22 12:01:00', 'Sunny Energy Inc.', '8002345678', 'info@sunnyenergyinc.com'),
('2023-05-22 12:02:00', 'Photonics Power LLC', '8003456789', 'support@photonicspower.com'),
('2023-05-22 12:03:00', 'Helios Dynamics', '8004567890', 'inquiries@heliosdynamics.com'),
('2023-05-22 12:04:00', 'SunPower Manufacturers', '8005678901', 'help@sunpowermanufacturers.com'),
('2023-05-22 12:05:00', 'RadiantStar Solar', '8006789012', 'contact@radiantstarsolar.com'),
('2023-05-22 12:06:00', 'Quantum Leap Energy', '8007890123', 'support@quantumleapenergy.com'),
('2023-05-22 12:07:00', 'NovaSun Industries', '8008901234', 'info@novasunindustries.com'),
('2023-05-22 12:08:00', 'EcoLite Power Co.', '8009012345', 'help@ecolitepower.com'),
('2023-05-22 12:09:00', 'Zephyr Solars', '8000123456', 'inquiries@zephyrsolars.com');


INSERT INTO sep4.sep4db.contact_info (time_add, name, phone_no, email)
VALUES
('2023-05-22 12:10:00', 'SolarTech Solutions', '8001234500', 'contact2@solartechsolutions.com'),
('2023-05-22 12:11:00', 'Sunny Energy Inc.', '8002345600', 'info2@sunnyenergyinc.com'),
('2023-05-22 12:12:00', 'Photonics Power LLC', '8003456700', 'support2@photonicspower.com'),
('2023-05-22 12:13:00', 'Helios Dynamics', '8004567800', 'inquiries2@heliosdynamics.com'),
('2023-05-22 12:14:00', 'SunPower Manufacturers', '8005678902', 'help2@sunpowermanufacturers.com'),
('2023-05-22 12:15:00', 'RadiantStar Solar', '8006789013', 'contact2@radiantstarsolar.com'),
('2023-05-22 12:16:00', 'Quantum Leap Energy', '8007890124', 'support2@quantumleapenergy.com'),
('2023-05-22 12:17:00', 'NovaSun Industries', '8008901235', 'info2@novasunindustries.com'),
('2023-05-22 12:18:00', 'EcoLite Power Co.', '8009012346', 'help2@ecolitepower.com'),
('2023-05-22 12:19:00', 'Zephyr Solars', '8000123457', 'inquiries2@zephyrsolars.com'),
('2023-05-22 13:00:00', 'SolarTech Solutions', '8001234568', 'contact@solartechsolutions.co.uk'),
('2023-05-22 13:01:00', 'Sunny Energy Inc.', '8002345679', 'info@sunnyenergyinc.co.uk'),
('2023-05-22 13:02:00', 'Photonics Power LLC', '8003456790', 'support@photonicspower.co.uk'),
('2023-05-22 13:03:00', 'Helios Dynamics', '8004567891', 'inquiries@heliosdynamics.co.uk'),
('2023-05-22 13:04:00', 'SunPower Manufacturers', '8005678902', 'help@sunpowermanufacturers.co.uk'),
('2023-05-22 13:05:00', 'RadiantStar Solar', '8006789013', 'contact@radiantstarsolar.co.uk'),
('2023-05-22 13:06:00', 'Quantum Leap Energy', '8007890124', 'support@quantumleapenergy.co.uk'),
('2023-05-22 13:07:00', 'NovaSun Industries', '8008901235', 'info@novasunindustries.co.uk'),
('2023-05-22 13:08:00', 'EcoLite Power Co.', '8009012346', 'help@ecolitepower.co.uk'),
('2023-05-22 13:09:00', 'Zephyr Solars', '8000123457', 'inquiries@zephyrsolars.co.uk');




INSERT INTO sep4.sep4db.model (model_no, manufacturer, type_)
VALUES
('STS001', 'SolarTech Solutions', 'electrical'),
('STS002', 'SolarTech Solutions', 'Thermal'),
('SEI001', 'Sunny Energy Inc.', 'electrical'),
('SEI002', 'Sunny Energy Inc.', 'Thermal'),
('PPL001', 'Photonics Power LLC', 'electrical'),
('PPL002', 'Photonics Power LLC', 'Thermal'),
('HD001', 'Helios Dynamics', 'electrical'),
('HD002', 'Helios Dynamics', 'Thermal'),
('SPM001', 'SunPower Manufacturers', 'electrical'),
('SPM002', 'SunPower Manufacturers', 'Thermal'),
('RSS001', 'RadiantStar Solar', 'electrical'),
('RSS002', 'RadiantStar Solar', 'Thermal'),
('QLE001', 'Quantum Leap Energy', 'electrical'),
('QLE002', 'Quantum Leap Energy', 'Thermal'),
('NSI001', 'NovaSun Industries', 'electrical'),
('NSI002', 'NovaSun Industries', 'Thermal'),
('EPC001', 'EcoLite Power Co.', 'electrical'),
('EPC002', 'EcoLite Power Co.', 'Thermal'),
('ZS001', 'Zephyr Solars', 'electrical'),
('ZS002', 'Zephyr Solars', 'Thermal');


INSERT INTO sep4.sep4db.solar_panel (installation_date, model_no)
VALUES
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'STS001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'SEI001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'PPL001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'HD001'	)	,
(	'2023-05-22'	,	'STS002'	)	,
(	'2023-05-22'	,	'STS002'	)	,
(	'2023-05-22'	,	'STS002'	)	,
(	'2023-05-22'	,	'NSI002'	)	,
(	'2023-05-22'	,	'NSI002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	,
(	'2023-05-22'	,	'RSS002'	)	;


SELECT count(*)
from sep4.sep4db.solar_panel;

INSERT INTO sep4.sep4db.active_panel(panel_id, column_, row_) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 1),
(7, 7, 1),
(8, 8, 1),
(9, 9, 1),
(10, 10, 1),
(11, 11, 1),
(12, 12, 1),
(13, 13, 1),
(14, 14, 1),
(15, 15, 1),
(16, 16, 1),
(17, 17, 1),
(18, 18, 1),
(19, 19, 1),
(20, 1, 2),
(21, 2, 2),
(22, 3, 2),
(23, 4, 2),
(24, 5, 2),
(25, 6, 2),
(26, 7, 2),
(27, 8, 2),
(28, 9, 2),
(29, 10, 2),
(30, 11, 2),
(31, 12, 2),
(32, 13, 2),
(33, 14, 2),
(34, 15, 2),
(35, 16, 2),
(36, 17, 2),
(37, 18, 2),
(38, 19, 2),
(39, 1, 3),
(40, 2, 3),
(41, 3, 3),
(42, 4, 3),
(43, 5, 3),
(44, 6, 3),
(45, 7, 3),
(46, 8, 3),
(47, 9, 3),
(48, 10, 3),
(49, 11, 3),
(50, 12, 3),
(51, 13, 3),
(52, 14, 3),
(53, 15, 3),
(54, 16, 3),
(55, 17, 3),
(56, 18, 3),
(57, 19, 3),
(58, 1, 4),
(59, 2, 4),
(60, 3, 4),
(61, 4, 4),
(62, 5, 4),
(63, 6, 4),
(64, 7, 4),
(65, 8, 4),
(66, 9, 4),
(67, 10, 4),
(68, 11, 4),
(69, 12, 4),
(70, 13, 4),
(71, 14, 4),
(72, 15, 4),
(73, 16, 4),
(74, 17, 4),
(75, 18, 4),
(76, 19, 4),
(77, 1, 5),
(78, 2, 5),
(79, 3, 5),
(80, 4, 5),
(81, 5, 5),
(82, 6, 5),
(83, 7, 5),
(84, 8, 5),
(85, 9, 5),
(86, 10, 5),
(87, 11, 5),
(88, 12, 5),
(89, 13, 5),
(90, 14, 5),
(91, 15, 5),
(92, 16, 5),
(93, 17, 5),
(94, 18, 5),
(95, 19, 5);

INSERT INTO sep4.sep4db.active_panel(panel_id, column_, row_) VALUES
(115, 1, 6),
(116, 2, 6),
(117, 3, 6),
(118, 4, 6),
(119, 5, 6),
(120, 6, 6),
(121, 7, 6),
(122, 8, 6),
(123, 9, 6),
(124, 10, 6),
(125, 11, 6),
(126, 12, 6),
(127, 13, 6),
(128, 14, 6),
(129, 15, 6),
(130, 16, 6),
(131, 17, 6),
(132, 18, 6),
(133, 19, 6);


INSERT INTO sep4.sep4db.active_panel(panel_id, column_, row_) VALUES
                                                                  (134,1,1);


select panel_id
from sep4.sep4db.active_panel
where column_= 1 AND row_ = 1;