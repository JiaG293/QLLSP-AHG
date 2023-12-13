
USE QLLSPAHG
GO

-- DU lieu cho tam Ung
INSERT [dbo].[TamUngNhanVien] ([maTUNV], [maNV], [ngayTamUng],[lyDo],[soTienTamUng])
VALUES
('TUNV100000121023', 'NV100000', '2023-12-10',N'Người nhà mất',1500000)

INSERT [dbo].[BangChamCongNhanVien] ([maBCCNV],[maNV],[ngayChamCong], [diLam] )
VALUES
('CCNV100000101223','NV100000','2023-12-10', 1)

INSERT [dbo].[BangChamCongNhanVien] ([maBCCNV],[maNV],[ngayChamCong], [diLam], [nghiPhep] )
VALUES
('CCNV100000071223','NV100000','2023-12-07', 1,0),
('CCNV100000061223','NV100000','2023-12-06', 1,0),
('CCNV100000051223','NV100000','2023-12-05', 1,0),
('CCNV100000041223','NV100000','2023-12-04', 1,0),
('CCNV100000031223','NV100000','2023-12-03', 1,0),
('CCNV100000021223','NV100000','2023-12-02', 1,0),
('CCNV100000011223','NV100000','2023-12-01', 1,0),
('CCNV100000091223','NV100000','2023-12-09', 0,1),
('CCNV100000081223','NV100000','2023-12-08', 0,1),
('CCNV100000081222','NV100000','2022-12-08', 0,1), --nam la 2022 de kiem tra coi cau truy van co dung la lay nam hien tai ko
('CCNV100000111223','NV100000','2023-12-11', 0,0)

INSERT [dbo].[BangChamCongNhanVien] ([maBCCNV],[maNV],[ngayChamCong], [diLam], [nghiPhep] )
VALUES
('CCNV100001071223','NV100001','2023-12-07', 1,0),
('CCNV100001061223','NV100001','2023-12-06', 1,0),
('CCNV100001051223','NV100001','2023-12-05', 1,0),
('CCNV100001041223','NV100001','2023-12-04', 1,0),
('CCNV100001031223','NV100001','2023-12-03', 1,0),
('CCNV100001021223','NV100001','2023-12-02', 1,0),
('CCNV100001011223','NV100001','2023-12-01', 1,0),
('CCNV100001091223','NV100001','2023-12-09', 0,1),
('CCNV100001081223','NV100001','2023-12-08', 0,1),
('CCNV100001101223','NV100001','2023-12-10', 1,0)

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
INSERT INTO [PhuCap] (maPhuCap, tienChuyenCan, tienNangSuat, tienConNho, tienNhaTro)
VALUES
    ('PCNV01', 155000, 0, 105020, 0),
    ('PCNV02', 24135, 13582, 13582, 23582),
    ('PCNV03', 24135, 30000, 13582, 23582),
    ('PCCN01', 155000, 0, 105020, 0),
    ('PCCN02', 21413, 45645, 45645, 45645),
    ('PCCN03', 30000, 300000, 30000, 30000);


--NhanVien
INSERT INTO [NhanVien] (maNV,maPB,maCV,maPhuCap,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,luongCoBan)
VALUES
    ('NV100000','PBHCNS','CVNVHC','PCNV01','Burt','Kelly','1','1974-02-19','5223275971','iaculis@gmail.com','2023-12-9','4929768247276589',3815135),
    ('NV100001','PBHCQL','CVNVKK','PCNV02','Hooper','Candice','0','1971-12-30','0482440333','vitae.dolor@gmail.com','2023-11-13','4513 5696 3233 9822',3758842),
    ('NV100002','PBHCTC','CVNVKT','PCNV03','Gonzales','Nicole','1','1987-01-15','1798595223','libero.proin.mi@gmail.com','2024-08-6','527929 3467156661',4314626);

--SanPham
INSERT INTO [SanPham] (maSP,tenLoai,tenSP,giaSP)
VALUES
    ('SP1000', N'Ba lô du lịch','Ba lô 1',336717),
    ('SP1001', N'Ba lô du lịch','Ba lô 2',583316),
    ('SP1002', N'Ba lô gia đình','Ba lô 3',314919),
    ('SP1003', N'Ba lô gia đình','Ba lô 4',1422084),
    ('SP1004', N'Ba lô du lịch','Ba lô 5',551996),
    ('SP1005', N'Ba lô du lịch','Ba lô 6',189141),
    ('SP1006', N'Ba lô du lịch','Ba lô 7',964416),
    ('SP1007', N'Ba lô gia đình','Ba lô 8',1471071),
    ('SP1008', N'Ba lô gia đình','Ba lô 9',762537),
    ('SP1009', N'Ba lô gia đình','Ba lô 10',508126),
    ('SP1010', N'Ba lô gia đình','Ba lô 11',1361004),
    ('SP1011', N'Ba lô du lịch','Ba lô 12',418800),
    ('SP1012', N'Ba lô du lịch','Ba lô 13',324340),
    ('SP1013', N'Ba lô du lịch','Ba lô 14',670933),
    ('SP1014', N'Ba lô du lịch','Ba lô 15',227817),
    ('SP1015', N'Ba lô du lịch','Ba lô 16',831840),
    ('SP1016', N'Ba lô gia đình','Ba lô 17',824665),
    ('SP1017', N'Ba lô du lịch','Ba lô 18',207858),
    ('SP1018', N'Ba lô du lịch','Ba lô 19',178306),
    ('SP1019', N'Ba lô du lịch','Ba lô 20',433883),
    ('SP1020', N'Ba lô du lịch','Ba lô 21',1360507),
    ('SP1021', N'Ba lô du lịch','Ba lô 22',1314585),
    ('SP1022', N'Ba lô gia đình','Ba lô 23',1472386),
    ('SP1023', N'Ba lô gia đình','Ba lô 24',852631),
    ('SP1024', N'Ba lô du lịch','Ba lô 25',1117126),
    ('SP1025', N'Ba lô gia đình','Ba lô 26',914453),
    ('SP1026', N'Ba lô du lịch','Ba lô 27',909102),
    ('SP1027', N'Ba lô gia đình','Ba lô 28',681707),
    ('SP1028', N'Ba lô du lịch','Ba lô 29',394358),
    ('SP1029', N'Ba lô gia đình','Ba lô 30',642394),
    ('SP1030', N'Ba lô du lịch','Ba lô 31',1389083),
    ('SP1031', N'Ba lô gia đình','Ba lô 32',1298378),
    ('SP1032', N'Ba lô du lịch','Ba lô 33',866941),
    ('SP1033', N'Ba lô du lịch','Ba lô 34',1188283);

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
INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat, soLuongDaLam)
VALUES
    ('HD100033','SP1000',7420, 0),
    ('HD100034','SP1001',4917, 0),
    ('HD100035','SP1002',4112, 0),
    ('HD100036','SP1003',2398, 0),
    ('HD100037','SP1004',3624, 0),
    ('HD100038','SP1005',1163, 0),
    ('HD100039','SP1006',6810, 0),
    ('HD100040','SP1007',8655, 0),
    ('HD100041','SP1008',1717, 0),
    ('HD100042','SP1009',5950, 0),
    ('HD100043','SP1010',2197, 0),
    ('HD100044','SP1011',6091, 0),
    ('HD100045','SP1012',1424, 0),
    ('HD100046','SP1013',6582, 0),
    ('HD100047','SP1014',9977, 0),
    ('HD100048','SP1015',5025, 0),
    ('HD100049','SP1016',6057, 0),
    ('HD100050','SP1017',5839, 0),
    ('HD100051','SP1018',5224, 0),
    ('HD100052','SP1019',6360, 0);

--ChiTietHopDongChuaThanhLySP2
INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat, soLuongDaLam)
VALUES
    ('HD100033','SP1020',8400, 0),
    ('HD100034','SP1021',6859, 0),
    ('HD100035','SP1022',585, 0),
    ('HD100036','SP1023',6839, 0),
    ('HD100037','SP1024',7752, 0),
    ('HD100038','SP1025',7888, 0),
    ('HD100039','SP1026',7402, 0),
    ('HD100040','SP1027',5315, 0),
    ('HD100041','SP1028',9471, 0),
    ('HD100042','SP1029',3927, 0),
    ('HD100043','SP1030',7400, 0);

--ChiTietHopDongChuaThanhLySP3
INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat, soLuongDaLam)
VALUES
    ('HD100033','SP1049',9679, 0),
    ('HD100034','SP1049',6676, 0),
    ('HD100035','SP1049',6535, 0),
    ('HD100036','SP1049',7301, 0),
    ('HD100037','SP1049',328, 0),
    ('HD100038','SP1049',1711, 0),
    ('HD100039','SP1049',674, 0),
    ('HD100040','SP1049',6092, 0),
    ('HD100041','SP1049',5114, 0),
    ('HD100042','SP1049',8737, 0);

--ChiTietHopDongThanhLySP1
INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat, soLuongDaLam)
VALUES
    ('HD100000','SP1000',7537,7537),
    ('HD100001','SP1001',8073,8073),
    ('HD100002','SP1002',9509,9509),
    ('HD100003','SP1003',1012,1012),
    ('HD100004','SP1004',1157,1157),
    ('HD100005','SP1005',3162,3162),
    ('HD100006','SP1006',7076,7076),
    ('HD100007','SP1007',3244,3244),
    ('HD100008','SP1008',548,548),
    ('HD100009','SP1009',1056,1056),
    ('HD100010','SP1010',1221,1221),
    ('HD100011','SP1011',2523,2523),
    ('HD100012','SP1012',1162,1162),
    ('HD100013','SP1013',7935,7935),
    ('HD100014','SP1014',5186,5186),
    ('HD100015','SP1015',757,757),
    ('HD100016','SP1016',1725,1725),
    ('HD100017','SP1017',3835,3835),
    ('HD100018','SP1018',7989,7989),
    ('HD100019','SP1019',5702,5702);

--ChiTietHopDongThanhLySP2
INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat, soLuongDaLam)
VALUES
    ('HD100000','SP1020',6442,6442),
    ('HD100001','SP1021',7277,7277),
    ('HD100002','SP1022',3007,3007),
    ('HD100003','SP1023',9209,9209),
    ('HD100004','SP1024',3653,3653),
    ('HD100005','SP1025',1689,1689),
    ('HD100006','SP1026',3310,3310),
    ('HD100007','SP1027',4984,4984),
    ('HD100008','SP1028',1035,1035),
    ('HD100009','SP1029',174,174),
    ('HD100010','SP1030',8360,8360),
    ('HD100011','SP1031',8362,8362),
    ('HD100012','SP1032',7086,7086),
    ('HD100013','SP1033',4492,4492),
    ('HD100014','SP1034',6174,6174),
    ('HD100015','SP1035',2832,2832),
    ('HD100016','SP1036',3455,3455),
    ('HD100017','SP1037',9105,9105),
    ('HD100018','SP1038',450,450),
    ('HD100019','SP1039',4599,4599);



--Update 1/12/2023

--New ChucVu CongNhan
INSERT INTO [ChucVu] (maCV, tenCV, heSoCV)
VALUES
    ('CVCNQL', N'Công nhân quản lý', 1.4),
    ('CVCNSX', N'Công nhân sản xuất', 1.1),
    ('CVCNTT', N'Công nhân tổ trưởng', 1.2);


--New ToSanXuat
INSERT INTO [ToSanXuat] (maTSX, tenTSX)
VALUES
    ('TSX001', N'Tổ 1'),
    ('TSX002', N'Tổ 2'),
    ('TSX003', N'Tổ 3'),
    ('TSX004', N'Tổ 4'),
    ('TSX005', N'Tổ 5'),
    ('TSX006', N'Tổ 6'),
    ('TSX007', N'Tổ 7'),
    ('TSX008', N'Tổ 8'),
    ('TSX009', N'Tổ 9'),
    ('TSX010', N'Tổ 10'),
    ('TSX011', N'Tổ 11'),
    ('TSX012', N'Tổ 12');

--new cong nhan Hoat Dong
INSERT INTO [CongNhan] (maCN,maCV,maTSX,maPhuCap,hoCN,tenCN,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK)
VALUES
    ('CN100000','CVCNSX','TSX009','PCCN02','Rodriguez','Brielle','1','1990-03-26','0937182214','tincidunt.dui@gmail.com','May 24, 2012','4929327986896287'),
    ('CN100001','CVCNSX','TSX012','PCCN02','Bryan','Alika','1','1999-01-03','0316051570','donec@gmail.com','Apr 26, 2014','4532365131828'),
    ('CN100002','CVCNTT','TSX008','PCCN03','Kane','Demetria','0','1992-09-10','0799278866','libero.at@gmail.com','Feb 2, 2015','4532425883363788'),
    ('CN100003','CVCNTT','TSX006','PCCN01','Olson','Alexandra','0','1992-05-18','0824895831','erat.vivamus@gmail.com','Jul 20, 2008','4122541464884335'),
    ('CN100004','CVCNSX','TSX002','PCCN03','Boyer','Ralph','1','1997-09-19','0946429884','diam.nunc@gmail.com','Aug 28, 2019','4485746889491'),
    ('CN100005','CVCNTT','TSX006','PCCN01','Caldwell','Maggie','0','1999-02-21','0706764457','sed.tortor@gmail.com','Jun 15, 2015','4225345324238278'),
    ('CN100006','CVCNSX','TSX006','PCCN01','Walls','Delilah','1','1993-02-18','0940216936','nulla.dignissim@gmail.com','Jun 24, 2011','4024007127679'),
    ('CN100007','CVCNTT','TSX001','PCCN02','Bender','Erich','0','2004-01-20','0936544652','lacinia@gmail.com','Oct 7, 2006','4485582454514772'),
    ('CN100008','CVCNQL','TSX006','PCCN02','Humphrey','Len','0','1994-09-24','0846401318','pede.blandit.congue@gmail.com','Mar 19, 2008','4485228748413'),
    ('CN100009','CVCNSX','TSX012','PCCN03','Rasmussen','Aquila','0','1994-07-06','0334631208','justo@gmail.com','Aug 24, 2012','4485468265688635'),
    ('CN100010','CVCNQL','TSX004','PCCN03','Mosley','Graham','0','1994-01-22','0774157213','elementum.dui@gmail.com','Oct 31, 2022','4532664923654554'),
    ('CN100011','CVCNTT','TSX011','PCCN01','Murphy','Raven','1','1993-01-10','0355212858','risus.morbi@gmail.com','Dec 18, 2019','4865658865441'),
    ('CN100012','CVCNQL','TSX001','PCCN02','Hines','Beck','0','1984-08-13','0872866546','suspendisse.tristique@gmail.com','Jul 22, 2008','4485924769434488'),
    ('CN100013','CVCNSX','TSX002','PCCN03','Downs','Chiquita','1','1987-05-20','0803870398','lobortis@gmail.com','Dec 23, 2005','4916521879596'),
    ('CN100014','CVCNQL','TSX006','PCCN03','Garrison','Charlotte','0','2003-06-01','0758936829','nec.mauris.blandit@gmail.com','Sep 26, 2019','4556447753424'),
    ('CN100015','CVCNTT','TSX004','PCCN01','Bray','Ira','1','1987-11-06','0376738986','lobortis.augue@gmail.com','Nov 22, 2009','4532954551899'),
    ('CN100016','CVCNQL','TSX007','PCCN03','Black','Arsenio','0','1997-02-06','0338508675','in.at.pede@gmail.com','Sep 7, 2009','4716162443268'),
    ('CN100017','CVCNSX','TSX012','PCCN01','Marsh','Cole','0','1994-05-10','0743726678','velit@gmail.com','Jul 2, 2006','4024007164789'),
    ('CN100018','CVCNSX','TSX012','PCCN01','Rowe','Penelope','1','1988-12-05','0756281644','consectetuer@gmail.com','Mar 28, 2016','4556722452338'),
    ('CN100019','CVCNSX','TSX002','PCCN02','Snow','Kasper','1','1990-11-17','0839720313','nulla@gmail.com','Sep 28, 2008','4532892115741471'),
    ('CN100020','CVCNSX','TSX010','PCCN02','Slater','Nerea','1','1985-11-19','0313856751','facilisis.magna@gmail.com','Oct 22, 2011','4485945781131166'),
    ('CN100021','CVCNTT','TSX010','PCCN01','Nunez','Barclay','1','2003-12-24','0985842912','integer.eu.lacus@gmail.com','Sep 8, 2007','4184548345253'),
    ('CN100022','CVCNTT','TSX008','PCCN02','Cleveland','Hamish','1','1984-10-26','0792344657','fringilla@gmail.com','Aug 23, 2009','4532922767270'),
    ('CN100023','CVCNQL','TSX006','PCCN01','Finley','Jonah','0','1988-09-13','0377724840','ut.pharetra@gmail.com','Oct 22, 2009','4539876545511'),
    ('CN100024','CVCNTT','TSX008','PCCN03','Edwards','John','1','1982-12-23','0845584279','in.magna@gmail.com','Aug 9, 2012','4539243815853187'),
    ('CN100025','CVCNTT','TSX012','PCCN02','Quinn','Helen','1','1985-08-19','0375286762','sit.amet.nulla@gmail.com','Nov 29, 2016','4716288861252'),
    ('CN100026','CVCNQL','TSX005','PCCN01','Meadows','Tana','1','1986-06-09','0976414909','fringilla.ornare@gmail.com','Mar 10, 2012','4532475848333665'),
    ('CN100027','CVCNQL','TSX001','PCCN03','Head','Patricia','0','2001-01-12','0808578361','ac.tellus.suspendisse@gmail.com','May 8, 2021','4916236811649859'),
    ('CN100028','CVCNSX','TSX006','PCCN03','Price','Magee','0','1988-08-17','0768306174','venenatis.lacus.etiam@gmail.com','Mar 21, 2019','4929617278254348'),
    ('CN100029','CVCNSX','TSX004','PCCN01','Larsen','Bianca','0','1991-07-17','0833136702','primis.in@gmail.com','Aug 25, 2014','4024007159382620');

--New COngNhanNghiViec
INSERT INTO [CongNhan] (maCN,maCV,maTSX,maPhuCap,hoCN,tenCN,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,trangThaiCN)
VALUES
    ('CN100100','CVCNTT','TSX009','PCCN02','Yates','Knox','0','1999-04-24','0351407605','arcu.iaculis@gmail.com','Dec 10, 2006','4539727125568238','1'),
    ('CN100101','CVCNQL','TSX010','PCCN01','Dominguez','Amanda','1','2002-06-21','0961747075','sed.est@gmail.com','Dec 22, 2007','4716896363478692','1'),
    ('CN100102','CVCNQL','TSX001','PCCN01','Blanchard','Larissa','1','1989-01-17','0377227701','purus@gmail.com','Feb 11, 2017','4485558984484959','1'),
    ('CN100103','CVCNQL','TSX003','PCCN01','Gill','Joel','0','1998-04-27','0338611954','per.inceptos.hymenaeos@gmail.com','May 7, 2007','4929435374895785','1'),
    ('CN100104','CVCNQL','TSX002','PCCN01','Dudley','Thor','1','1991-05-14','0356035434','phasellus.ornare@gmail.com','Oct 9, 2012','4716854212898','1'),
    ('CN100105','CVCNSX','TSX006','PCCN02','Kim','Vera','1','1999-08-18','0733788808','convallis.convallis@gmail.com','Nov 8, 2008','4916666163434','1'),
    ('CN100106','CVCNSX','TSX002','PCCN02','Perry','Montana','1','2004-03-18','0778890726','felis.orci@gmail.com','Jun 23, 2016','4556852511432456','1'),
    ('CN100107','CVCNSX','TSX008','PCCN02','Byers','Hall','1','1992-03-13','0324324865','interdum.sed@gmail.com','Jun 18, 2005','4532566674211957','1'),
    ('CN100108','CVCNQL','TSX005','PCCN02','Klein','Jessica','1','1995-08-14','0716274525','diam.sed.diam@gmail.com','Sep 29, 2018','4024007187236','1'),
    ('CN100109','CVCNSX','TSX007','PCCN01','Garcia','Bree','1','1994-04-16','0715548358','vitae@gmail.com','Sep 13, 2006','4024007128370','1');



--Update 11-12-2023

-- COng doan

INSERT INTO CongDoan (maCD, maSP, tenCD, giaiDoan, giaCongDoan)
VALUES
    ('CDSP10171', 'SP1017', N'Cắt', N'Cắt', 10000),
    ('CDSP10172', 'SP1017', N'May', N'Cắt', 10000),
    ('CDSP10174', 'SP1017', N'Hoàn thành', N'Cắt', 10000),
    ('CDSP10175', 'SP1017', N'Đóng gói', N'Cắt', 10000);

INSERT INTO CongDoan (maCD, maSP, tenCD, giaiDoan, giaCongDoan)
VALUES
    ('CDSP10061', 'SP1006', N'Cắt', N'Cắt', 10000),
    ('CDSP10062', 'SP1006', N'May', N'Cắt', 10000),
    ('CDSP10064', 'SP1006', N'Hoàn thành', N'Cắt', 10000),
    ('CDSP10065', 'SP1006', N'Đóng gói', N'Cắt', 10000);














