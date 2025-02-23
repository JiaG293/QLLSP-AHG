﻿
USE QLLSPAHG
GO
--PhongBan
  INSERT INTO [PhongBan] (maPB, tenPB)
  VALUES
	('PBHCNS', N'Phòng nhân sự'),
	('PBHCTC', N'Phòng tài chính'),
	('PBHCQL', N'Phòng quản lý');

	--ChucVu
INSERT INTO [ChucVu] (maCV, tenCV, heSoCV)
  VALUES
	('CVNVHC', N'Nhân viên hành chính', 1.1),
	('CVNVKK', N'Nhân viên kiểm kê', 1.3),
	('CVNVKT', N'Nhân viên kế toán', 1.4),
	('CVNVQL', N'Nhân viên quản lý', 1.5);

		--PhuCap
INSERT INTO [PhuCap] (maPhuCap, tienChuyenCan, tienNangSuat, tienConNho, tienDiLai, tienNhaTro, tienDienThoai)
  VALUES
	('PCNV01', 155000, 0, 105020, 0, 0, 0),
	('PCNV02', 24135, 13582, 13582, 24582, 23582, 21582),
	('PCNV03', 24135, 30000, 13582, 30000, 23582, 30000),
	('PCCN01', 155000, 0, 105020, 0, 0, 0),
	('PCCN02', 21413, 45645, 45645, 300000, 45645, 35645),
	('PCCN03', 30000, 300000, 30000, 30000, 30000, 30000);


	--NhanVien
INSERT INTO [NhanVien] (maNV,maPB,maCV,maPhuCap,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,luongCoBan)
VALUES
  ('NV100000','PBHCNS','CVNVHC','PCNV01','Burt','Kelly','1','1974-02-19','5223275971','iaculis@gmail.com','2023-12-9','4929768247276589',3815135),
  ('NV100001','PBHCQL','CVNVKK','PCNV02','Hooper','Candice','0','1971-12-30','0482440333','vitae.dolor@gmail.com','2023-11-13','4513 5696 3233 9822',3758842),
  ('NV100002','PBHCTC','CVNVKT','PCNV03','Gonzales','Nicole','1','1987-01-15','1798595223','libero.proin.mi@gmail.com','2024-08-6','527929 3467156661',4314626),
  ('NV100003','PBHCNS','CVNVQL','PCCN01','Graham','Logan','1','1970-05-22','9375551774','erat.volutpat@gmail.com','2023-05-22','4485 1158 5687 7628',4294025),
  ('NV100004','PBHCQL','CVNVHC','PCNV02','Gordon','Glenna','1','1972-05-17','3642971488','nunc.mauris@gmail.com','2023-01-30','544 25751 38448 358',4212867),
  ('NV100005','PBHCTC','CVNVKK','PCNV03','Richmond','Hayfa','1','1970-12-29','0785767750','odio.tristique@gmail.com','2023-06-7','543 88725 67267 714',4436824),
  ('NV100006','PBHCNS','CVNVKT','PCNV01','Mccarty','Raphael','0','1997-11-7','7371200499','mauris@gmail.com','2023-09-1','525284 3616688583',3842868),
  ('NV100007','PBHCQL','CVNVQL','PCNV02','Brady','Maxine','0','1968-04-21','2635818459','sodales.nisi@gmail.com','2023-12-8','4024007154458862',3690984),
  ('NV100008','PBHCTC','CVNVHC','PCNV03','Dillon','Talon','0','2000-08-24','7658096525','amet@gmail.com','2023-02-21','4539 563 56 7414',3779281),
  ('NV100009','PBHCNS','CVNVKK','PCCN01','Dotson','Mara','0','1990-01-7','2235618898','dolor.sit@gmail.com','2024-06-13','5283 9147 9845 8682',4248815),
  ('NV100010','PBHCQL','CVNVKT','PCNV02','Tanner','Xantha','1','1995-12-13','6526484551','vulputate.velit@gmail.com','2023-06-5','402400 7168773769',4025628),
  ('NV100011','PBHCTC','CVNVQL','PCNV03','Burch','Rigel','0','1996-02-16','7371642263','semper.rutrum@gmail.com','2024-04-12','537 48495 57542 815',4442423),
  ('NV100012','PBHCNS','CVNVHC','PCNV01','Riddle','Solomon','0','1981-02-16','7413589486','ipsum@gmail.com','2023-02-25','537215 2775747528',4318902),
  ('NV100013','PBHCQL','CVNVKK','PCNV02','Santana','Bevis','1','2004-03-29','2205963628','euismod.ac.fermentum@gmail.com','2023-10-24','542729 855877 5551',4360957),
  ('NV100014','PBHCTC','CVNVKT','PCNV03','Petersen','Alfonso','0','1985-07-16','1767812867','dolor.donec.fringilla@gmail.com','2024-01-19','557 36253 68562 575',4082810),
  ('NV100015','PBHCNS','CVNVQL','PCCN01','Hester','Susan','1','1991-11-1','4689598958','ornare.libero.at@gmail.com','2024-07-25','4539668733770',4115611),
  ('NV100016','PBHCQL','CVNVHC','PCNV02','Brennan','Ingrid','1','2002-02-18','8472647456','dolor.egestas@gmail.com','2023-06-13','402400 7164566159',3628785),
  ('NV100017','PBHCTC','CVNVKK','PCNV03','Strickland','Hillary','1','1987-07-24','5762211627','non.justo@gmail.com','2023-01-20','4929 945 95 6247',3861476),
  ('NV100018','PBHCNS','CVNVKT','PCNV01','Griffith','Shaeleigh','0','1973-12-27','5755778041','mollis@gmail.com','2024-04-3','534782 231444 1641',3941114),
  ('NV100019','PBHCQL','CVNVQL','PCNV02','Barron','Elmo','0','1987-05-20','5023106052','aliquet.phasellus@gmail.com','2024-10-19','533854 1668126449',4289518),
  ('NV100020','PBHCTC','CVNVHC','PCNV03','Guzman','Judah','1','1991-08-26','5611414567','lobortis.ultrices.vivamus@gmail.com','2023-04-5','531326 7323365276',4220452),
  ('NV100021','PBHCNS','CVNVKK','PCCN01','Avery','Donovan','0','2000-10-8','8774585722','mauris.eu@gmail.com','2024-04-12','471644 2844989294',4313417),
  ('NV100022','PBHCQL','CVNVKT','PCNV02','Lester','MacKenzie','0','1989-11-11','3750526286','amet.risus@gmail.com','2023-01-3','4556358149713275',4241339),
  ('NV100023','PBHCTC','CVNVQL','PCNV03','Crosby','Penelope','1','1979-10-3','1951434043','orci.luctus.et@gmail.com','2023-01-10','543145 7569838543',4013912),
  ('NV100024','PBHCNS','CVNVHC','PCNV01','Murray','Signe','1','1983-08-27','3638643717','ornare@gmail.com','2023-03-13','4485 582 51 5358',3536370),
  ('NV100025','PBHCQL','CVNVKK','PCNV02','Langley','Raymond','0','1975-09-18','7663960734','viverra.maecenas@gmail.com','2022-11-29','5142 7152 5888 3520',4165848),
  ('NV100026','PBHCTC','CVNVKT','PCNV03','Kline','Illiana','1','1967-10-22','5188386615','nullam@gmail.com','2024-07-5','402400 7172626789',4493847),
  ('NV100027','PBHCNS','CVNVQL','PCCN01','Finley','Adria','1','1989-04-1','4206474326','eleifend.nunc@gmail.com','2023-01-9','5114 8554 7765 4874',3565260),
  ('NV100028','PBHCQL','CVNVHC','PCNV02','George','Tamekah','0','1994-09-13','5875915911','aliquam.eu@gmail.com','2023-04-1','4532386636264576',4389792),
  ('NV100029','PBHCTC','CVNVKK','PCNV03','Chase','Prescott','0','1970-04-8','1786472423','massa.quisque.porttitor@gmail.com','2024-05-18','4485 886 44 6557',4462428),
  ('NV100030','PBHCNS','CVNVKT','PCNV01','Cobb','Bruce','0','2000-11-3','5652070581','egestas.lacinia@gmail.com','2024-05-6','5322 8237 2463 4592',4101801),
  ('NV100031','PBHCQL','CVNVQL','PCNV02','Poole','Yoshi','1','1992-10-18','0579469405','aliquam.nisl@gmail.com','2024-08-14','4532548312964',4240696),
  ('NV100032','PBHCTC','CVNVHC','PCNV03','Guzman','Blaze','1','1995-08-9','3535510306','tristique.senectus@gmail.com','2024-09-9','4774554824637',4197862),
  ('NV100033','PBHCNS','CVNVKK','PCCN01','Michael','Evelyn','1','1982-07-19','0961875708','fusce.mollis@gmail.com','2024-04-4','4916761644849293',3740713),
  ('NV100034','PBHCQL','CVNVKT','PCNV02','Wood','Iliana','1','1977-06-10','9373575521','ac@gmail.com','2024-02-19','5238 4832 2354 2268',3718981),
  ('NV100035','PBHCTC','CVNVQL','PCNV03','Leblanc','Ishmael','0','1972-08-18','2226278416','nunc.sed@gmail.com','2023-06-21','537 24554 34878 224',4011272),
  ('NV100036','PBHCNS','CVNVHC','PCNV01','William','Vera','1','1992-07-18','2160430284','velit@gmail.com','2024-04-7','457312 2822441862',3814908),
  ('NV100037','PBHCQL','CVNVKK','PCNV02','Castaneda','Pandora','1','1990-11-3','8301330746','lorem.donec.elementum@gmail.com','2023-06-15','4024007164681883',3951666),
  ('NV100038','PBHCTC','CVNVKT','PCNV03','Bullock','Kareem','1','1995-12-1','2872416422','sapien.molestie@gmail.com','2023-08-18','4929 1553 4243 3853',4479697),
  ('NV100039','PBHCNS','CVNVQL','PCCN01','Wood','Kyra','1','1996-04-30','6043875821','consequat@gmail.com','2024-07-2','4346229372829796',4306112),
  ('NV100040','PBHCQL','CVNVHC','PCNV02','Dawson','MacKensie','1','1972-01-1','3292126767','tristique.senectus@gmail.com','2022-12-8','4929 3282 1173 2479',3828262),
  ('NV100041','PBHCTC','CVNVKK','PCNV03','Hendricks','Tamekah','0','1976-12-9','2773218460','elit.fermentum.risus@gmail.com','2024-08-7','554792 717428 1389',4243028),
  ('NV100042','PBHCNS','CVNVKT','PCNV01','Savage','Xandra','0','1969-09-5','3641036838','aenean.egestas@gmail.com','2023-12-19','4485496347724',3767728),
  ('NV100043','PBHCQL','CVNVQL','PCNV02','Parrish','Malcolm','0','1968-02-20','6650775683','sit.amet@gmail.com','2023-03-6','4368467341222395',4468156),
  ('NV100044','PBHCTC','CVNVHC','PCNV03','Henson','Isaiah','0','1989-05-12','7025425777','pellentesque.sed@gmail.com','2023-06-26','533634 3182357770',3793176),
  ('NV100045','PBHCNS','CVNVKK','PCCN01','Pacheco','Colleen','0','1981-04-14','0673242415','et.magnis@gmail.com','2023-04-11','5334 9787 5966 4538',3879679),
  ('NV100046','PBHCQL','CVNVKT','PCNV02','Boyle','Slade','1','1996-10-31','8728487118','donec.at.arcu@gmail.com','2023-02-17','551263 5876346423',4400651),
  ('NV100047','PBHCTC','CVNVQL','PCNV03','Ramirez','Britanni','0','1985-08-14','6716573456','mauris.aliquam.eu@gmail.com','2023-08-2','4537133858347',3862898),
  ('NV100048','PBHCNS','CVNVHC','PCNV01','Beach','Jakeem','1','1989-08-17','5168250537','viverra.donec.tempus@gmail.com','2024-07-10','4485 5281 6242 6395',3949536),
  ('NV100049','PBHCQL','CVNVKK','PCNV02','Chan','Laura','0','1980-02-3','4236516316','condimentum.donec@gmail.com','2024-07-10','5172 6742 2125 8745',3572004);

INSERT INTO [NhanVien] (maNV,maPB,maCV,maPhuCap,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,luongCoBan)
VALUES
  ('NV100050','PBHCTC','CVNVKT','PCNV03','Mullins','Shoshana','0','2005-10-2','5559103645','convallis.dolor@gmail.com','2023-09-26','542 23235 48273 213',3837302),
  ('NV100051','PBHCNS','CVNVQL','PCCN01','Walters','Amy','1','1995-03-5','9635428218','nascetur.ridiculus@gmail.com','2024-03-17','4716572444593672',4291689),
  ('NV100052','PBHCQL','CVNVHC','PCNV02','Farley','Erasmus','0','1992-09-23','5463853450','placerat.augue@gmail.com','2024-03-25','4916 2667 6887 5892',4402656),
  ('NV100053','PBHCTC','CVNVKK','PCNV03','Campos','Hunter','1','1996-05-16','9507559324','aliquam.ultrices@gmail.com','2022-12-12','402400 7161169833',3885406),
  ('NV100054','PBHCNS','CVNVKT','PCNV01','Lewis','Winter','0','1991-02-8','1033321213','in.lorem@gmail.com','2023-05-25','5487 6222 3826 9338',4377599),
  ('NV100055','PBHCQL','CVNVQL','PCNV02','Forbes','Gray','0','1977-03-28','4297517738','ac.risus@gmail.com','2023-04-28','518 33651 55625 721',3969693),
  ('NV100056','PBHCTC','CVNVHC','PCNV03','Hale','Iliana','1','1992-06-30','2112342986','faucibus.ut@gmail.com','2024-03-15','453955 7456187369',3607087),
  ('NV100057','PBHCNS','CVNVKK','PCCN01','Wagner','Ina','1','1983-11-5','7214707554','libero.morbi.accumsan@gmail.com','2023-02-28','5418 5746 3265 7549',4326928),
  ('NV100058','PBHCQL','CVNVKT','PCNV02','Hamilton','Danielle','1','1970-07-1','6622524636','ligula.donec@gmail.com','2024-04-18','5196953722894238',3926384),
  ('NV100059','PBHCTC','CVNVQL','PCNV03','Bentley','Kevyn','0','1984-12-22','6681683642','elementum@gmail.com','2023-12-3','453254 3586844548',3715659),
  ('NV100060','PBHCNS','CVNVHC','PCNV01','Doyle','Joshua','1','1995-10-3','2716128514','interdum.nunc@gmail.com','2023-12-30','546834 7832842610',3524515),
  ('NV100061','PBHCQL','CVNVKK','PCNV02','Franks','Adrian','0','1997-12-26','8385255198','odio.tristique@gmail.com','2023-07-10','4556346841544',4143884),
  ('NV100062','PBHCTC','CVNVKT','PCNV03','Jensen','Hedda','0','2000-01-11','5246025432','elit.aliquam@gmail.com','2023-09-22','4929 8214 1852 2495',3532906),
  ('NV100063','PBHCNS','CVNVQL','PCCN01','Phillips','Marvin','0','2003-02-24','2096619819','enim@gmail.com','2024-06-14','4916483474915',4153064),
  ('NV100064','PBHCQL','CVNVHC','PCNV02','Franklin','Reece','1','1977-04-20','3824535944','eget.ipsum.suspendisse@gmail.com','2024-03-19','5584 9737 3846 4420',4417803),
  ('NV100065','PBHCTC','CVNVKK','PCNV03','Barr','Pamela','0','1991-12-21','4428275322','lorem.eu@gmail.com','2023-02-20','492927 6374517635',3633911),
  ('NV100066','PBHCNS','CVNVKT','PCNV01','Pate','Cade','1','1994-01-23','4295208251','lacus.etiam.bibendum@gmail.com','2023-04-7','474958 3136326553',4089189),
  ('NV100067','PBHCQL','CVNVQL','PCNV02','Cain','Adrian','1','1968-02-20','9755413057','ultrices.duis@gmail.com','2023-09-22','528 43679 37794 575',3756486),
  ('NV100068','PBHCTC','CVNVHC','PCNV03','Richardson','Yardley','1','1986-06-2','5148131424','nibh.vulputate@gmail.com','2024-03-17','546596 293679 6992',3980606),
  ('NV100069','PBHCNS','CVNVKK','PCCN01','Juarez','Kelly','1','1986-10-31','6547871276','nam.ac.nulla@gmail.com','2024-04-5','524632 2563723122',3812511),
  ('NV100070','PBHCQL','CVNVKT','PCNV02','Bowman','Eliana','1','1974-03-26','8275011735','sed.pharetra.felis@gmail.com','2024-10-28','5553 5626 8258 3371',3610262),
  ('NV100071','PBHCTC','CVNVQL','PCNV03','Prince','Buckminster','1','1996-03-23','6524444812','eu@gmail.com','2023-07-9','5166 9936 6449 8362',3851855),
  ('NV100072','PBHCNS','CVNVHC','PCNV01','Delgado','Abdul','0','1972-02-18','4074266178','mattis.cras@gmail.com','2022-11-18','543488 3355952395',4238930),
  ('NV100073','PBHCQL','CVNVKK','PCNV02','Cabrera','Armando','1','1969-07-30','8517228150','dictum.proin@gmail.com','2022-11-21','4916 124 49 9875',4433585),
  ('NV100074','PBHCTC','CVNVKT','PCNV03','Boyle','Leroy','1','1981-12-2','3366376188','elementum.purus.accumsan@gmail.com','2024-05-6','514654 672436 1544',4084816),
  ('NV100075','PBHCNS','CVNVQL','PCCN01','Mcleod','Xantha','1','2001-04-14','0491595315','nisi.aenean@gmail.com','2024-09-12','528 94457 83276 569',3709418),
  ('NV100076','PBHCQL','CVNVHC','PCNV02','Roman','Benjamin','1','1976-08-24','5486342342','natoque@gmail.com','2023-05-15','448586 8698747769',4108601),
  ('NV100077','PBHCTC','CVNVKK','PCNV03','Salazar','Jenna','0','1975-04-24','7858364198','eu@gmail.com','2023-11-16','4929582348229',4256403),
  ('NV100078','PBHCNS','CVNVKT','PCNV01','Duran','Margaret','0','1971-06-18','6889851463','nunc.commodo@gmail.com','2023-10-7','4532831484345431',4274517),
  ('NV100079','PBHCQL','CVNVQL','PCNV02','Holmes','Len','1','1989-07-29','5653394793','sem.semper@gmail.com','2023-12-24','522273 9195764935',4021809),
  ('NV100080','PBHCTC','CVNVHC','PCNV03','Gay','Cedric','1','1996-10-13','6619146457','donec.non@gmail.com','2024-10-17','4485 6787 3433 2934',3572310),
  ('NV100081','PBHCNS','CVNVKK','PCCN01','Hunter','Neil','0','1979-06-25','7214227735','tempus.scelerisque@gmail.com','2024-07-11','4929 4997 9552 2329',4467562),
  ('NV100082','PBHCQL','CVNVKT','PCNV02','Reyes','Serina','0','1994-02-17','4473334283','tempus@gmail.com','2024-06-5','5324468666533168',3617313),
  ('NV100083','PBHCTC','CVNVQL','PCNV03','Barber','Lee','0','1969-12-23','9784274111','varius@gmail.com','2024-04-13','5147993363154849',3740443),
  ('NV100084','PBHCNS','CVNVHC','PCNV01','Mckee','Zia','1','2004-11-2','6356542566','augue.eu.tellus@gmail.com','2023-01-8','522582 8652255458',3865663),
  ('NV100085','PBHCQL','CVNVKK','PCNV02','Moses','Aline','1','1994-04-25','6666720108','quisque@gmail.com','2023-02-7','5518448362939253',3751889),
  ('NV100086','PBHCTC','CVNVKT','PCNV03','House','Valentine','0','1984-09-18','5588357044','donec.dignissim@gmail.com','2024-10-26','517 42871 97375 415',3774397),
  ('NV100087','PBHCNS','CVNVQL','PCCN01','Berger','Dante','1','1989-05-31','2079663428','nunc.est@gmail.com','2024-04-23','527 27378 56682 858',4068165),
  ('NV100088','PBHCQL','CVNVHC','PCNV02','Nichols','Kiara','1','1991-11-7','7697973732','pede@gmail.com','2023-07-27','5496 7942 8863 2332',3884517),
  ('NV100089','PBHCTC','CVNVKK','PCNV03','Lang','Jason','1','1986-02-10','2605373376','ut.nisi.a@gmail.com','2023-01-28','455659 8245158343',4095679),
  ('NV100090','PBHCNS','CVNVKT','PCNV01','Mclean','Karly','0','1982-04-20','7652406747','vivamus.sit.amet@gmail.com','2023-12-1','4024 007 12 5590',4052976),
  ('NV100091','PBHCQL','CVNVQL','PCNV02','Santos','Hadley','1','1972-04-20','6572447352','adipiscing.elit@gmail.com','2024-09-30','4024007137942',4493516),
  ('NV100092','PBHCTC','CVNVHC','PCNV03','Maxwell','Ruth','1','1972-05-26','8732517852','tincidunt.congue.turpis@gmail.com','2023-03-29','527242 674344 5873',4048782),
  ('NV100093','PBHCNS','CVNVKK','PCCN01','Watson','Slade','0','1977-10-19','6167163252','scelerisque.neque@gmail.com','2023-09-29','4916 273 29 4663',3675169),
  ('NV100094','PBHCQL','CVNVKT','PCNV02','Ford','Barclay','0','1971-04-29','5533456444','interdum@gmail.com','2024-07-18','538 42735 14681 442',4351743),
  ('NV100095','PBHCTC','CVNVQL','PCNV03','Fox','Quon','0','1998-11-2','3537842254','euismod.enim@gmail.com','2024-10-3','4539732125887489',4088247),
  ('NV100096','PBHCNS','CVNVHC','PCNV01','Rivas','Zelenia','1','1994-12-18','0051188744','justo.nec@gmail.com','2024-01-31','4916 3334 6679 7388',3711160),
  ('NV100097','PBHCQL','CVNVKK','PCNV02','Santiago','Raja','1','1968-12-14','4045645612','phasellus.ornare@gmail.com','2023-05-22','542784 1166824541',3961086),
  ('NV100098','PBHCTC','CVNVKT','PCNV03','Phillips','Reuben','1','1990-11-28','3281464148','erat.vel@gmail.com','2023-06-17','5256 5378 2726 4293',3628970),
  ('NV100099','PBHCNS','CVNVQL','PCCN01','Buchanan','Abraham','1','1985-12-26','6968056271','mauris@gmail.com','2024-03-2','4929841517838',3702938);

INSERT INTO [NhanVien] (maNV,maPB,maCV,maPhuCap,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,luongCoBan)
VALUES
  ('NV100100','PBHCQL','CVNVHC','PCNV02','Salazar','Macey','0','1974-07-25','7447575836','sed.sapien@gmail.com','2024-07-10','5383493725464716',4035360),
  ('NV100101','PBHCTC','CVNVKK','PCNV03','Mcmillan','Alana','1','2004-03-31','6470379635','laoreet@gmail.com','2023-03-5','538979 6664543371',3674912),
  ('NV100102','PBHCNS','CVNVKT','PCNV01','Dixon','Arsenio','0','2003-07-19','8340532802','quis.tristique@gmail.com','2024-01-2','4716514285235',4100349),
  ('NV100103','PBHCQL','CVNVQL','PCNV02','Freeman','Yasir','1','1976-10-28','4893817490','in.nec@gmail.com','2024-07-2','5527624974658742',4346576),
  ('NV100104','PBHCTC','CVNVHC','PCNV03','Barr','Aspen','1','1991-08-24','9406254304','gravida@gmail.com','2023-02-24','511 66788 13821 231',3830229),
  ('NV100105','PBHCNS','CVNVKK','PCCN01','Boone','Lisandra','0','1999-03-6','5193758143','vulputate.eu@gmail.com','2024-02-14','4539684889440',4481294),
  ('NV100106','PBHCQL','CVNVKT','PCNV02','Robles','Kylynn','1','1981-01-25','7801848502','orci.luctus@gmail.com','2023-12-16','517696 622843 4790',4147254),
  ('NV100107','PBHCTC','CVNVQL','PCNV03','Wiggins','Liberty','0','1985-02-9','9752835275','donec.feugiat.metus@gmail.com','2023-10-17','4567839364829794',4049033),
  ('NV100108','PBHCNS','CVNVHC','PCNV01','Tyson','Samuel','1','1983-02-7','7926536016','non.feugiat.nec@gmail.com','2024-09-27','4532 4732 7386 4882',3639355),
  ('NV100109','PBHCQL','CVNVKK','PCNV02','Gould','Brock','1','1971-02-4','0381966721','semper.pretium@gmail.com','2023-06-20','4532 2852 4256 6392',4156727),
  ('NV100110','PBHCTC','CVNVKT','PCNV03','Campbell','Lawrence','1','1995-06-21','1228553067','nascetur.ridiculus.mus@gmail.com','2024-06-2','5396 8356 1723 5635',4091190),
  ('NV100111','PBHCNS','CVNVQL','PCCN01','Dudley','Hilda','0','2004-05-1','1332427988','ac.orci@gmail.com','2023-08-21','4929823842324357',3900109),
  ('NV100112','PBHCQL','CVNVHC','PCNV02','George','Tamekah','0','1991-07-9','6515357708','dui.semper@gmail.com','2023-01-5','4916 667 88 4145',3533191),
  ('NV100113','PBHCTC','CVNVKK','PCNV03','Holcomb','Quintessa','1','1992-08-2','3696987606','mauris.ut@gmail.com','2023-06-2','538241 6746684625',4230330),
  ('NV100114','PBHCNS','CVNVKT','PCNV01','Mann','Warren','0','2000-11-24','1797641633','amet.dapibus@gmail.com','2024-08-10','555741 6567455633',4099527),
  ('NV100115','PBHCQL','CVNVQL','PCNV02','Hill','Walker','1','1971-11-9','5467222333','nullam.ut@gmail.com','2022-12-3','542288 8663469275',3889947),
  ('NV100116','PBHCTC','CVNVHC','PCNV03','Fischer','Kenyon','0','1995-06-5','3337658388','fermentum@gmail.com','2024-06-18','5244 7842 7593 7468',3500642),
  ('NV100117','PBHCNS','CVNVKK','PCCN01','Harrell','Guy','0','1989-07-4','1972138414','scelerisque.sed@gmail.com','2024-10-27','558331 177758 7549',3924658),
  ('NV100118','PBHCQL','CVNVKT','PCNV02','Kelly','Fiona','0','1994-04-24','7741834046','dui@gmail.com','2024-09-21','4556 4628 4925 7938',4499154),
  ('NV100119','PBHCTC','CVNVQL','PCNV03','Lamb','Zelenia','0','1968-03-11','2411475838','pellentesque.ut@gmail.com','2024-09-12','5152 2762 6756 9367',4415831),
  ('NV100120','PBHCNS','CVNVHC','PCNV01','Mullins','Meghan','1','1987-12-21','7575524618','ac.facilisis@gmail.com','2023-10-24','535262 7728244412',4468785),
  ('NV100121','PBHCQL','CVNVKK','PCNV02','Ellis','Cyrus','0','1991-11-7','6829182647','consequat.nec.mollis@gmail.com','2023-03-15','4539231634778',4369655),
  ('NV100122','PBHCTC','CVNVKT','PCNV03','Eaton','Christian','0','1969-08-5','8953276554','mollis.vitae@gmail.com','2023-01-17','524366 6333123382',4074543),
  ('NV100123','PBHCNS','CVNVQL','PCCN01','Tanner','Shelby','1','1996-03-16','3964895814','etiam.laoreet.libero@gmail.com','2023-09-27','4539819611488680',4039205),
  ('NV100124','PBHCQL','CVNVHC','PCNV02','White','Addison','1','1986-07-8','7233642895','ac.fermentum.vel@gmail.com','2024-01-28','546 47369 23666 835',3714332),
  ('NV100125','PBHCTC','CVNVKK','PCNV03','Howell','Nola','1','1980-08-26','5041567413','nisl.nulla@gmail.com','2023-09-19','448521 6337654139',4092371),
  ('NV100126','PBHCNS','CVNVKT','PCNV01','Vega','Shelby','0','1973-12-11','5313233266','dictum.magna.ut@gmail.com','2022-12-8','4929625317488',4243638),
  ('NV100127','PBHCQL','CVNVQL','PCNV02','Hale','Quamar','1','1972-11-7','8651433739','id.blandit.at@gmail.com','2024-04-25','557 43317 88389 843',4489802),
  ('NV100128','PBHCTC','CVNVHC','PCNV03','Bryant','Melvin','0','1989-03-9','7585856798','varius.et@gmail.com','2022-12-5','4539 461 94 4715',4267038),
  ('NV100129','PBHCNS','CVNVKK','PCCN01','Stevenson','Rudyard','0','1969-10-20','3625322688','nulla.integer@gmail.com','2024-03-6','4583 6618 8292 6468',4221234),
  ('NV100130','PBHCQL','CVNVKT','PCNV02','Henderson','Leo','0','2005-06-3','3396557961','ac@gmail.com','2023-03-3','4485924538923795',3832118),
  ('NV100131','PBHCTC','CVNVQL','PCNV03','Blake','Madeson','0','1988-07-25','7693607654','non.sollicitudin@gmail.com','2023-10-2','5124718483699317',4113881),
  ('NV100132','PBHCNS','CVNVHC','PCNV01','Larson','Dacey','0','1990-02-27','7452523530','luctus.sit@gmail.com','2023-02-6','5326 4454 7614 9474',4384059),
  ('NV100133','PBHCQL','CVNVKK','PCNV02','Santos','Hilda','1','1977-09-28','4219034683','lorem.ipsum@gmail.com','2024-01-1','517874 2665478378',4002126),
  ('NV100134','PBHCTC','CVNVKT','PCNV03','Mclean','Brenden','1','1967-11-25','3792442855','quis.urna@gmail.com','2024-11-4','516484 7276265548',3908371),
  ('NV100135','PBHCNS','CVNVQL','PCCN01','Ballard','Mohammad','1','1980-04-3','1051152414','vehicula@gmail.com','2023-10-29','534474 752783 8452',4492337),
  ('NV100136','PBHCQL','CVNVHC','PCNV02','Davis','Channing','0','1974-12-6','8863542638','diam.duis.mi@gmail.com','2023-05-21','552 22214 85733 232',4317027),
  ('NV100137','PBHCTC','CVNVKK','PCNV03','Page','Kaye','1','2005-03-7','8178631610','vulputate.mauris.sagittis@gmail.com','2024-06-7','4556612837663',4346743),
  ('NV100138','PBHCNS','CVNVKT','PCNV01','Carlson','Xena','0','1983-06-24','4445771477','nam.nulla@gmail.com','2023-03-17','555 98356 48337 254',4039751),
  ('NV100139','PBHCQL','CVNVQL','PCNV02','Sexton','Maggie','1','1988-08-9','5806840814','vulputate.posuere.vulputate@gmail.com','2022-12-14','4556353741348',3938428),
  ('NV100140','PBHCTC','CVNVHC','PCNV03','Diaz','Sade','1','2001-11-28','7442487011','curae.donec.tincidunt@gmail.com','2023-12-6','5382786367331460',4277944),
  ('NV100141','PBHCNS','CVNVKK','PCCN01','Whitfield','Mallory','1','1982-03-7','6171714849','a.scelerisque.sed@gmail.com','2023-03-1','5568513923363639',4026356),
  ('NV100142','PBHCQL','CVNVKT','PCNV02','Moss','Hillary','0','2005-10-25','1668850971','semper@gmail.com','2024-10-27','5273 7489 1838 4572',4179957),
  ('NV100143','PBHCTC','CVNVQL','PCNV03','Morrow','Addison','1','1992-06-23','1725244833','neque.nullam@gmail.com','2023-03-19','4532113743511479',3512875),
  ('NV100144','PBHCNS','CVNVHC','PCNV01','Cummings','Randall','1','1985-11-17','1427487775','vivamus.molestie@gmail.com','2024-02-7','5336523434344680',4399856),
  ('NV100145','PBHCQL','CVNVKK','PCNV02','Walton','Nichole','1','1984-12-7','5101312515','commodo@gmail.com','2023-05-13','527526 487153 2155',3844880),
  ('NV100146','PBHCTC','CVNVKT','PCNV03','Vaughn','Xantha','0','1999-08-18','3049523646','sagittis.lobortis@gmail.com','2023-07-16','471676 5466282790',3949478),
  ('NV100147','PBHCNS','CVNVQL','PCCN01','Olsen','Finn','0','2004-10-9','6508576866','integer@gmail.com','2024-08-20','557423 8787768259',4206471),
  ('NV100148','PBHCQL','CVNVHC','PCNV02','Woodard','Kiayada','1','1993-08-30','7895636611','luctus@gmail.com','2023-08-9','529586 8639525586',3895500),
  ('NV100149','PBHCTC','CVNVKK','PCNV03','Case','Mason','0','1976-08-22','9471863533','tincidunt@gmail.com','2023-01-2','515377 355756 9437',4496366);

INSERT INTO [NhanVien] (maNV,maPB,maCV,maPhuCap,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,luongCoBan)
VALUES
  ('NV100150','PBHCNS','CVNVKT','PCNV01','Mccall','Jeremy','1','2000-12-7','6784225835','lacinia@gmail.com','2023-08-22','455662 5933754271',3762734),
  ('NV100151','PBHCQL','CVNVQL','PCNV02','Sykes','Miriam','0','1981-01-23','9907618591','nunc@gmail.com','2024-10-10','5258 4877 2761 6648',3903199),
  ('NV100152','PBHCTC','CVNVHC','PCNV03','Cotton','Mary','0','1978-06-24','4238682497','purus.in.molestie@gmail.com','2024-01-24','542649 2533636670',4184162),
  ('NV100153','PBHCNS','CVNVKK','PCCN01','Lynch','Dean','0','1971-07-11','7252533252','tincidunt.congue@gmail.com','2024-04-30','4556642132372656',3692313),
  ('NV100154','PBHCQL','CVNVKT','PCNV02','Barker','Ina','1','1967-01-20','3686018828','nec.ante@gmail.com','2024-03-14','5282 6621 3533 2547',4021909),
  ('NV100155','PBHCTC','CVNVQL','PCNV03','Dyer','Jessamine','0','1970-02-20','6512434492','feugiat.lorem@gmail.com','2024-02-22','531 82964 58661 576',4209939),
  ('NV100156','PBHCNS','CVNVHC','PCNV01','Alvarez','Ava','0','1984-09-22','1452838108','aliquet.nec@gmail.com','2023-03-15','5233 8221 4157 8687',3971393),
  ('NV100157','PBHCQL','CVNVKK','PCNV02','Cox','Alexander','0','1982-09-26','9374656611','elit.pretium@gmail.com','2023-07-25','4539464732893',4173765),
  ('NV100158','PBHCTC','CVNVKT','PCNV03','Fry','Sydney','1','1991-06-29','3453167567','nunc.ullamcorper.eu@gmail.com','2023-03-20','516827 665276 6661',4187493),
  ('NV100159','PBHCNS','CVNVQL','PCCN01','Gibson','Blaze','0','2002-04-5','7874826908','pede.nunc.sed@gmail.com','2024-02-21','549484 483954 7950',4478821),
  ('NV100160','PBHCQL','CVNVHC','PCNV02','Horne','Amena','0','1983-06-25','1291784954','cras.vulputate@gmail.com','2023-09-4','4532 473 39 9234',4343271),
  ('NV100161','PBHCTC','CVNVKK','PCNV03','Le','Walter','0','1986-01-11','7112507945','natoque@gmail.com','2023-04-3','533 57262 32119 839',3745299),
  ('NV100162','PBHCNS','CVNVKT','PCNV01','Trevino','Tad','1','1979-01-4','7153696111','pellentesque.habitant@gmail.com','2023-09-29','523374 712637 6825',4208850),
  ('NV100163','PBHCQL','CVNVQL','PCNV02','Stephenson','Alyssa','0','1999-07-29','2755449817','augue.sed@gmail.com','2024-10-23','4916146285552176',3511926),
  ('NV100164','PBHCTC','CVNVHC','PCNV03','Robbins','Anastasia','1','1990-03-7','7625897705','semper@gmail.com','2024-10-11','4024 0071 3382 9522',3744536),
  ('NV100165','PBHCNS','CVNVKK','PCCN01','Bowen','Ashton','1','1968-07-26','4601479779','sed@gmail.com','2023-08-11','4024007171651',4459861),
  ('NV100166','PBHCQL','CVNVKT','PCNV02','Hodges','Maite','0','1978-02-25','0362867442','ac@gmail.com','2023-07-22','5162 4453 7787 9382',3985338),
  ('NV100167','PBHCTC','CVNVQL','PCNV03','Bates','Naomi','1','1979-12-4','7327809327','ullamcorper.velit.in@gmail.com','2024-05-19','556596 964253 6884',4296661),
  ('NV100168','PBHCNS','CVNVHC','PCNV01','Vaughn','Ariana','0','1989-05-12','1986920293','vestibulum.nec@gmail.com','2022-11-21','532 52454 24453 924',3862930),
  ('NV100169','PBHCQL','CVNVKK','PCNV02','Odom','Rigel','1','1997-11-2','0476548542','tristique.pharetra.quisque@gmail.com','2023-02-19','4485342336561321',4180086),
  ('NV100170','PBHCTC','CVNVKT','PCNV03','Hoffman','Rigel','0','1995-11-9','1176045771','ornare.fusce@gmail.com','2024-06-25','542 23489 62562 726',4329761),
  ('NV100171','PBHCNS','CVNVQL','PCCN01','Winters','Ingrid','0','1987-02-12','6022786423','aliquam@gmail.com','2023-04-18','471696 4223736319',4440925),
  ('NV100172','PBHCQL','CVNVHC','PCNV02','Duncan','Lydia','0','1967-03-22','5357244233','erat@gmail.com','2023-12-10','4485884614420',4356470),
  ('NV100173','PBHCTC','CVNVKK','PCNV03','Arnold','Megan','0','1969-07-1','9361661149','morbi@gmail.com','2024-03-19','4556868372167',4366861),
  ('NV100174','PBHCNS','CVNVKT','PCNV01','Knox','Callum','1','1991-01-16','5441430255','aliquam.eros.turpis@gmail.com','2024-05-26','555 76652 44326 837',3502371),
  ('NV100175','PBHCQL','CVNVQL','PCNV02','Turner','Jessamine','1','1991-10-30','5753994143','dui@gmail.com','2023-11-12','5377893652886351',4361308),
  ('NV100176','PBHCTC','CVNVHC','PCNV03','Alvarado','Myles','0','1992-02-3','5536551127','in.condimentum@gmail.com','2024-04-17','4812 353 46 8857',3737632),
  ('NV100177','PBHCNS','CVNVKK','PCCN01','Duke','Clare','0','1997-10-5','1112403248','posuere.cubilia@gmail.com','2023-07-26','4539455827586940',4418969),
  ('NV100178','PBHCQL','CVNVKT','PCNV02','Olsen','Rogan','1','1985-12-17','2855308325','arcu@gmail.com','2023-02-26','4916 362 57 5378',4008313),
  ('NV100179','PBHCTC','CVNVQL','PCNV03','Michael','Simone','0','1975-03-9','2131347494','quam.a@gmail.com','2023-06-9','5186535193682358',3892290),
  ('NV100180','PBHCNS','CVNVHC','PCNV01','Harrell','Keelie','0','1998-11-24','8613320378','etiam@gmail.com','2023-09-29','4356 586 24 2473',3794522),
  ('NV100181','PBHCQL','CVNVKK','PCNV02','Phelps','Dominic','0','1977-01-11','2446644344','risus.nunc.ac@gmail.com','2024-05-11','5398 9532 3352 9857',4117798),
  ('NV100182','PBHCTC','CVNVKT','PCNV03','Patterson','Brady','1','1989-05-3','9100877743','sagittis.lobortis@gmail.com','2024-05-21','4916613257263',4026382),
  ('NV100183','PBHCNS','CVNVQL','PCCN01','Hopper','Aileen','1','1979-04-10','1679082139','eu.turpis@gmail.com','2023-09-29','518736 8328223750',3992094),
  ('NV100184','PBHCQL','CVNVHC','PCNV02','Mcbride','Curran','1','1995-07-1','0312413342','odio.sagittis.semper@gmail.com','2024-06-21','556 33176 43221 647',4246874),
  ('NV100185','PBHCTC','CVNVKK','PCNV03','Marshall','Nathan','1','1992-03-1','4897318487','ut.quam@gmail.com','2024-09-30','4485622483880',4398604),
  ('NV100186','PBHCNS','CVNVKT','PCNV01','Norris','Ali','1','1980-09-10','2814441888','purus.gravida.sagittis@gmail.com','2024-06-10','4916 5913 9374 6881',4252513),
  ('NV100187','PBHCQL','CVNVQL','PCNV02','Fleming','Serena','1','2003-06-22','4833761577','at.sem.molestie@gmail.com','2023-06-1','402400 7132838227',3530753),
  ('NV100188','PBHCTC','CVNVHC','PCNV03','Hess','Neil','0','1980-09-6','7988451822','odio.a@gmail.com','2023-03-24','456375 6457854873',4248093),
  ('NV100189','PBHCNS','CVNVKK','PCCN01','Bryant','Cameron','0','1990-05-25','8540827261','sapien.nunc@gmail.com','2023-12-26','532 47282 82967 565',4137351),
  ('NV100190','PBHCQL','CVNVKT','PCNV02','Sykes','Ciaran','0','1998-06-4','5767277570','ante@gmail.com','2023-10-7','4716 722 48 2863',3762880),
  ('NV100191','PBHCTC','CVNVQL','PCNV03','Hodges','Cassidy','0','1977-06-17','0165946352','a@gmail.com','2024-09-29','453233 4832291670',3694199),
  ('NV100192','PBHCNS','CVNVHC','PCNV01','Ruiz','Nero','0','1987-08-16','1291922645','elit.erat@gmail.com','2024-07-9','534326 413848 7266',4141009),
  ('NV100193','PBHCQL','CVNVKK','PCNV02','Wolf','Sharon','1','1970-06-13','2371177187','ut@gmail.com','2023-03-29','5587783592895461',3664587),
  ('NV100194','PBHCTC','CVNVKT','PCNV03','Silva','Rachel','1','1995-02-16','7007518444','aenean@gmail.com','2024-07-6','4916165834168870',3673393),
  ('NV100195','PBHCNS','CVNVQL','PCCN01','Harvey','Carlos','0','1999-09-6','5822050828','quis@gmail.com','2024-01-6','5154 3449 2827 4484',3649195),
  ('NV100196','PBHCQL','CVNVHC','PCNV02','Davidson','William','0','1978-08-15','2263972260','vestibulum.nec@gmail.com','2024-09-14','515 21528 98341 684',4350786),
  ('NV100197','PBHCTC','CVNVKK','PCNV03','Hull','Pascale','1','2003-11-28','6352621065','felis.eget@gmail.com','2023-12-30','402400 7187737431',4477046),
  ('NV100198','PBHCNS','CVNVKT','PCNV01','Fowler','Joy','0','1978-03-23','2529848616','augue@gmail.com','2024-04-28','4916 475 42 7350',3659357),
  ('NV100199','PBHCQL','CVNVQL','PCNV02','Mcfarland','Sebastian','0','1973-08-28','2539327482','bibendum.donec@gmail.com','2024-01-29','4916 469 35 3638',3830904);

  --SanPham 
  INSERT INTO [SanPham] (maSP,tenLoai,tenSP,giaSP)
VALUES
  ('SP1000','Ba lô du lịch','Ba lô 1',336717),
  ('SP1001','Ba lô du lịch','Ba lô 2',583316),
  ('SP1002','Ba lô gia đình','Ba lô 3',314919),
  ('SP1003','Ba lô gia đình','Ba lô 4',1422084),
  ('SP1004','Ba lô du lịch','Ba lô 5',551996),
  ('SP1005','Ba lô du lịch','Ba lô 6',189141),
  ('SP1006','Ba lô du lịch','Ba lô 7',964416),
  ('SP1007','Ba lô gia đình','Ba lô 8',1471071),
  ('SP1008','Ba lô gia đình','Ba lô 9',762537),
  ('SP1009','Ba lô gia đình','Ba lô 10',508126),
  ('SP1010','Ba lô gia đình','Ba lô 11',1361004),
  ('SP1011','Ba lô du lịch','Ba lô 12',418800),
  ('SP1012','Ba lô du lịch','Ba lô 13',324340),
  ('SP1013','Ba lô du lịch','Ba lô 14',670933),
  ('SP1014','Ba lô du lịch','Ba lô 15',227817),
  ('SP1015','Ba lô du lịch','Ba lô 16',831840),
  ('SP1016','Ba lô gia đình','Ba lô 17',824665),
  ('SP1017','Ba lô du lịch','Ba lô 18',207858),
  ('SP1018','Ba lô du lịch','Ba lô 19',178306),
  ('SP1019','Ba lô du lịch','Ba lô 20',433883),
  ('SP1020','Ba lô du lịch','Ba lô 21',1360507),
  ('SP1021','Ba lô du lịch','Ba lô 22',1314585),
  ('SP1022','Ba lô gia đình','Ba lô 23',1472386),
  ('SP1023','Ba lô gia đình','Ba lô 24',852631),
  ('SP1024','Ba lô du lịch','Ba lô 25',1117126),
  ('SP1025','Ba lô gia đình','Ba lô 26',914453),
  ('SP1026','Ba lô du lịch','Ba lô 27',909102),
  ('SP1027','Ba lô gia đình','Ba lô 28',681707),
  ('SP1028','Ba lô du lịch','Ba lô 29',394358),
  ('SP1029','Ba lô gia đình','Ba lô 30',642394),
  ('SP1030','Ba lô du lịch','Ba lô 31',1389083),
  ('SP1031','Ba lô gia đình','Ba lô 32',1298378),
  ('SP1032','Ba lô du lịch','Ba lô 33',866941),
  ('SP1033','Ba lô du lịch','Ba lô 34',1188283),
  ('SP1034','Ba lô du lịch','Ba lô 35',1172062),
  ('SP1035','Ba lô du lịch','Ba lô 36',1453170),
  ('SP1036','Ba lô gia đình','Ba lô 37',617085),
  ('SP1037','Ba lô du lịch','Ba lô 38',910722),
  ('SP1038','Ba lô du lịch','Ba lô 39',861251),
  ('SP1039','Ba lô gia đình','Ba lô 40',578600),
  ('SP1040','Ba lô du lịch','Ba lô 41',604781),
  ('SP1041','Ba lô du lịch','Ba lô 42',820422),
  ('SP1042','Ba lô du lịch','Ba lô 43',448801),
  ('SP1043','Ba lô gia đình','Ba lô 44',1037562),
  ('SP1044','Ba lô gia đình','Ba lô 45',1474724),
  ('SP1045','Ba lô gia đình','Ba lô 46',183236),
  ('SP1046','Ba lô du lịch','Ba lô 47',482955),
  ('SP1047','Ba lô du lịch','Ba lô 48',794791),
  ('SP1048','Ba lô gia đình','Ba lô 49',1028117),
  ('SP1049','Ba lô du lịch','Ba lô 50',202865);

  --CongDoanSanPham maCongDoan doi thanh CD+MaSP+ *(1 so)
  INSERT [dbo].[CongDoan] ([maCD], [maSP], [tenCD], [giaCongDoan]) 
VALUES ('CDSP10001', 'SP1000', N'Cắt', 10000) 
INSERT [dbo].[CongDoan] ([maCD], [maSP], [tenCD], [giaCongDoan]) 
VALUES ('CDSP10002', 'SP1000', N'Mai', 10000) 
INSERT [dbo].[CongDoan] ([maCD], [maSP], [tenCD], [giaCongDoan]) 
VALUES ('CDSP10003', 'SP1000', N'Hoàn thành', 10000) 
INSERT [dbo].[CongDoan] ([maCD], [maSP], [tenCD], [giaCongDoan]) 
VALUES ('CDSP10004', 'SP1000', N'Đóng gói', 10000) 

INSERT [dbo].[CongDoan] ([maCD], [maSP], [tenCD], [giaCongDoan]) 
VALUES ('CDSP10011', 'SP1001', N'Cắt', 10000) 
INSERT [dbo].[CongDoan] ([maCD], [maSP], [tenCD], [giaCongDoan]) 
VALUES ('CDSP10012', 'SP1001', N'Mai', 10000) 
INSERT [dbo].[CongDoan] ([maCD], [maSP], [tenCD], [giaCongDoan]) 
VALUES ('CDSP10013', 'SP1001', N'Hoàn thành', 10000 )
INSERT [dbo].[CongDoan] ([maCD], [maSP], [tenCD], [giaCongDoan]) 
VALUES ('CDSP10014', 'SP1001', N'Đóng gói', 10000)

  --HopDongChuaThanhLy
  INSERT INTO [HopDong] (maHD,tenKH,sDT,diaChi,email,ngayKKHD,ngayTLHD,trangThaiHD)
VALUES
  ('HD100033','Demetrius Barr','0902131164','Ap #857-6123 A Rd.','ut.cursus@gmail.com','2022-12-03','2025-02-05','0'),
  ('HD100034','Sandra Trujillo','0384681788','Ap #842-4006 Mus. Rd.','auctor.quis@gmail.com','2023-01-02','2025-02-07','0'),
  ('HD100035','Harper Guzman','0380855481','P.O. Box 227, 8182 Justo. Street','scelerisque.neque.sed@gmail.com','2022-11-24','2025-01-19','0'),
  ('HD100036','Rina Conrad','0386416613','8803 Mi Ave','egestas.ligula@gmail.com','2022-12-15','2024-06-23','0'),
  ('HD100037','Amir English','0386052450','P.O. Box 634, 7293 Donec Road','dictum@gmail.com','2022-12-31','2024-06-10','0'),
  ('HD100038','Cullen Vaughan','0906491634','Ap #478-4053 Velit Rd.','conubia.nostra.per@gmail.com','2022-12-07','2025-08-19','0'),
  ('HD100039','Nadine Sutton','0373666868','Ap #656-2732 Laoreet St.','sagittis.nullam@gmail.com','2023-01-05','2024-04-06','0'),
  ('HD100040','Macon Rhodes','0908875846','318-8758 Nullam Street','enim.mi@gmail.com','2022-12-27','2025-05-09','0'),
  ('HD100041','Tashya Mckay','0377012261','651-925 Id Road','sit@gmail.com','2022-12-01','2024-06-08','0'),
  ('HD100042','Alexander Tanner','0388235546','Ap #585-5906 Cras Ave','tristique.aliquet@gmail.com','2022-11-20','2025-08-10','0'),
  ('HD100043','Debra Bradford','0380418985','3741 Ac Avenue','nunc.sed.orci@gmail.com','2022-12-17','2025-04-29','0'),
  ('HD100044','MacKensie Mcgee','0372490615','Ap #876-9907 Lectus Avenue','adipiscing.mauris@gmail.com','2022-12-31','2025-03-29','0'),
  ('HD100045','Ruth Potts','0900676729','Ap #769-676 Tellus. Ave','fermentum.metus.aenean@gmail.com','2022-12-19','2024-11-30','0'),
  ('HD100046','Dora Hunter','0383251773','Ap #844-359 Ante Rd.','lacus.etiam@gmail.com','2022-11-10','2024-05-04','0'),
  ('HD100047','Michelle Neal','0386340644','5315 Hendrerit. Street','et@gmail.com','2022-11-20','2024-04-28','0'),
  ('HD100048','Chancellor Jefferson','0909177862','109-383 Ut Av.','quam.quis@gmail.com','2022-11-10','2024-06-23','0'),
  ('HD100049','Denise Gillespie','0904363651','P.O. Box 518, 7830 Ligula. St.','semper@gmail.com','2022-11-15','2024-08-08','0'),
  ('HD100050','Jakeem Baxter','0374749060','1805 Nunc Rd.','ipsum.donec@gmail.com','2022-12-13','2024-03-10','0'),
  ('HD100051','Quamar Slater','0371313661','Ap #155-3625 Vulputate, Av.','urna@gmail.com','2022-12-17','2024-10-26','0'),
  ('HD100052','Kalia Norman','0376723366','P.O. Box 135, 8588 Non Avenue','pede.nec.ante@gmail.com','2023-01-04','2024-07-14','0');

  --HopDongThanhLy
  INSERT INTO [HopDong] (maHD,tenKH,sDT,diaChi,email,ngayKKHD,ngayTLHD,trangThaiHD)
VALUES
  ('HD100000','Kalia Mcdaniel','0900856716','Ap #880-5637 Maecenas Ave','phasellus.at@gmail.com','2022-11-27','2023-01-31','1'),
  ('HD100001','Oliver Monroe','0901130683','189-9031 Scelerisque, Road','felis.ullamcorper@gmail.com','2023-01-04','2023-04-26','1'),
  ('HD100002','Cameron Cotton','0386142383','P.O. Box 954, 5519 Odio Road','et.ultrices.posuere@gmail.com','2022-11-18','2023-04-29','1'),
  ('HD100003','Alan Pickett','0388743805','528-7035 Natoque Rd.','id.sapien.cras@gmail.com','2023-01-06','2023-03-17','1'),
  ('HD100004','Vivien Porter','0388503008','736-2994 Eget Av.','tincidunt.donec@gmail.com','2022-11-12','2023-08-22','1'),
  ('HD100005','Seth Mejia','0376968106','6842 Et Av.','commodo.auctor@gmail.com','2022-11-23','2023-05-20','1'),
  ('HD100006','Stephen Lamb','0903843356','374-3644 Lectus Rd.','rhoncus.proin@gmail.com','2022-12-25','2023-03-05','1'),
  ('HD100007','Kiona Love','0904462589','P.O. Box 834, 4325 Duis Rd.','donec@gmail.com','2023-01-06','2023-08-19','1'),
  ('HD100008','Bevis Wiggins','0382535674','Ap #685-5278 Sed Avenue','gravida.aliquam@gmail.com','2023-01-10','2023-02-25','1'),
  ('HD100009','Adam Harrington','0372068216','172-6859 Nulla. Rd.','aliquam.nisl@gmail.com','2022-12-27','2023-04-07','1'),
  ('HD100010','Desiree Patton','0377478957','7847 Ac, Street','ut.nisi@gmail.com','2022-12-09','2023-08-19','1'),
  ('HD100011','Samson Avery','0901120063','264-2961 Mi Ave','nunc.laoreet@gmail.com','2022-12-31','2023-03-11','1'),
  ('HD100012','Plato Bartlett','0385258329','870-789 Magna. Av.','risus.varius.orci@gmail.com','2022-12-08','2023-06-17','1'),
  ('HD100013','Roary Nicholson','0901120319','2290 Duis Avenue','eros@gmail.com','2022-11-27','2023-02-13','1'),
  ('HD100014','Lars Dickson','0382723161','1011 Praesent Street','molestie.sodales@gmail.com','2022-11-08','2023-07-05','1'),
  ('HD100015','Joan Downs','0906242764','752-5267 Ligula. St.','consectetuer.mauris@gmail.com','2022-11-10','2023-06-12','1'),
  ('HD100016','Giselle Rasmussen','0389601484','8820 Nulla Avenue','nisl.nulla@gmail.com','2022-12-20','2023-06-06','1'),
  ('HD100017','Josiah Davis','0377483252','264-5754 Mi Street','nullam.feugiat@gmail.com','2022-12-19','2023-02-16','1'),
  ('HD100018','Kessie Zamora','0386564276','Ap #204-620 Lorem, St.','fringilla.porttitor@gmail.com','2022-12-30','2023-01-29','1'),
  ('HD100019','Kessie Henry','0387068296','P.O. Box 271, 7199 Natoque St.','dolor.sit.amet@gmail.com','2022-12-25','2023-02-24','1');

  --ChiTietHopDongChuaThanhLySP1
  INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat)
VALUES
  ('HD100033','SP1000',7420),
  ('HD100034','SP1001',4917),
  ('HD100035','SP1002',4112),
  ('HD100036','SP1003',2398),
  ('HD100037','SP1004',3624),
  ('HD100038','SP1005',1163),
  ('HD100039','SP1006',6810),
  ('HD100040','SP1007',8655),
  ('HD100041','SP1008',1717),
  ('HD100042','SP1009',5950),
  ('HD100043','SP1010',2197),
  ('HD100044','SP1011',6091),
  ('HD100045','SP1012',1424),
  ('HD100046','SP1013',6582),
  ('HD100047','SP1014',9977),
  ('HD100048','SP1015',5025),
  ('HD100049','SP1016',6057),
  ('HD100050','SP1017',5839),
  ('HD100051','SP1018',5224),
  ('HD100052','SP1019',6360);

  --ChiTietHopDongChuaThanhLySP2
  INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat)
VALUES
  ('HD100033','SP1020',8400),
  ('HD100034','SP1021',6859),
  ('HD100035','SP1022',585),
  ('HD100036','SP1023',6839),
  ('HD100037','SP1024',7752),
  ('HD100038','SP1025',7888),
  ('HD100039','SP1026',7402),
  ('HD100040','SP1027',5315),
  ('HD100041','SP1028',9471),
  ('HD100042','SP1029',3927),
  ('HD100043','SP1030',7400),
  ('HD100044','SP1031',5721),
  ('HD100045','SP1032',2488),
  ('HD100046','SP1033',1449),
  ('HD100047','SP1034',2935),
  ('HD100048','SP1035',328),
  ('HD100049','SP1036',1189),
  ('HD100050','SP1037',533),
  ('HD100051','SP1038',9460),
  ('HD100052','SP1039',4190);

--ChiTietHopDongChuaThanhLySP3
INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat)
VALUES
  ('HD100033','SP1049',9679),
  ('HD100034','SP1049',6676),
  ('HD100035','SP1049',6535),
  ('HD100036','SP1049',7301),
  ('HD100037','SP1049',328),
  ('HD100038','SP1049',1711),
  ('HD100039','SP1049',674),
  ('HD100040','SP1049',6092),
  ('HD100041','SP1049',5114),
  ('HD100042','SP1049',8737);

   --ChiTietHopDongThanhLySP1
   INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat)
VALUES
  ('HD100000','SP1000',7537),
  ('HD100001','SP1001',8073),
  ('HD100002','SP1002',9509),
  ('HD100003','SP1003',1012),
  ('HD100004','SP1004',1157),
  ('HD100005','SP1005',3162),
  ('HD100006','SP1006',7076),
  ('HD100007','SP1007',3244),
  ('HD100008','SP1008',548),
  ('HD100009','SP1009',1056),
  ('HD100010','SP1010',1221),
  ('HD100011','SP1011',2523),
  ('HD100012','SP1012',1162),
  ('HD100013','SP1013',7935),
  ('HD100014','SP1014',5186),
  ('HD100015','SP1015',757),
  ('HD100016','SP1016',1725),
  ('HD100017','SP1017',3835),
  ('HD100018','SP1018',7989),
  ('HD100019','SP1019',5702);

  --ChiTietHopDongThanhLySP2
  INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat)
VALUES
  ('HD100000','SP1020',6442),
  ('HD100001','SP1021',7277),
  ('HD100002','SP1022',3007),
  ('HD100003','SP1023',9209),
  ('HD100004','SP1024',3653),
  ('HD100005','SP1025',1689),
  ('HD100006','SP1026',3310),
  ('HD100007','SP1027',4984),
  ('HD100008','SP1028',1035),
  ('HD100009','SP1029',174),
  ('HD100010','SP1030',8360),
  ('HD100011','SP1031',8362),
  ('HD100012','SP1032',7086),
  ('HD100013','SP1033',4492),
  ('HD100014','SP1034',6174),
  ('HD100015','SP1035',2832),
  ('HD100016','SP1036',3455),
  ('HD100017','SP1037',9105),
  ('HD100018','SP1038',450),
  ('HD100019','SP1039',4599);
  







  



