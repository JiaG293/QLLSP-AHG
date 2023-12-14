

--PhongBanTable
  INSERT INTO [PhongBan] (maPB, tenPB)
  VALUES
	('PBHCNS', N'Phòng nhân sự'),
	('PBHCTC', N'Phòng tài chính'),
	('PBHCQL', N'Phòng quản lý');

--ChucVuTable
INSERT INTO [ChucVu] (maCV, tenCV, heSoCV)
VALUES
    ('CVNVHC', N'Nhân viên hành chính', 1.1),
    ('CVNVTT', N'Nhân viên thực tập', 1),
    ('CVNVKT', N'Nhân viên kế toán', 1.3),
    ('CVNVQL', N'Nhân viên quản lý', 1.5),
	('CVCNQL', N'Công nhân quản lý', 1.4),
    ('CVCNSX', N'Công nhân sản xuất', 1.1);

--PhuCap
INSERT INTO [PhuCap] (maPhuCap, tienChuyenCan, tienNangSuat, tienConNho, tienNhaTro)
VALUES
    ('PCNV01', 300000, 0, 100000, 50000),
    ('PCNV02', 300000, 0, 0, 50000),
    ('PCNV03', 300000, 0, 0, 50000),
    ('PCCN01', 0, 300000, 0, 50000),
    ('PCCN02', 0, 300000, 100000, 50000),
    ('PCCN03', 0, 300000, 0, 0);

INSERT INTO [SanPham] (maSP,tenLoai,tenSP,giaSP)
VALUES
    ('SP1000', N'Ba lô du lịch','Ba lô 001',220000),
    ('SP1001', N'Ba lô du lịch','Ba lô 002',230000),
    ('SP1002', N'Ba lô gia đình','Ba lô 003',500000);

--CongDoanTable
INSERT INTO [CongDoan] (maCD, maSP, tenCD, giaiDoan, giaCongDoan)
VALUES
	('CDSP10001', 'SP1000', N'Cắt 1', N'Cắt', 5000),
	('CDSP10002', 'SP1000', N'Cắt 2', N'Cắt', 5000),
	('CDSP10003', 'SP1000', N'May 1', N'May', 10000),
	('CDSP10004', 'SP1000', N'May 2', N'May', 10000),
	('CDSP10005', 'SP1000', N'Hoàn thành', N'Hoàn thành', 10000),
	('CDSP10006', 'SP1000', N'Đóng gói', N'Đóng gói', 10000);

	INSERT INTO [CongDoan] (maCD, maSP, tenCD, giaiDoan, giaCongDoan)
VALUES
	('CDSP10011', 'SP1001', N'Cắt 1', N'Cắt', 5000),
	('CDSP10012', 'SP1001', N'Cắt 2', N'Cắt', 5000),
	('CDSP10013', 'SP1001', N'May 1', N'May', 10000),
	('CDSP10014', 'SP1001', N'May 2', N'May', 10000),
	('CDSP10015', 'SP1001', N'Hoàn thành', N'Hoàn thành', 10000),
	('CDSP10016', 'SP1001', N'Đóng gói', N'Đóng gói', 10000);

INSERT INTO [CongDoan] (maCD, maSP, tenCD, giaiDoan, giaCongDoan)
VALUES
	('CDSP10021', 'SP1002', N'Cắt 1', N'Cắt', 10000),
	('CDSP10022', 'SP1002', N'Cắt 2', N'Cắt', 10000),
	('CDSP10023', 'SP1002', N'May 1', N'May', 20000),
	('CDSP10024', 'SP1002', N'May 2', N'May', 20000),
	('CDSP10025', 'SP1002', N'Hoàn thành', N'Hoàn thành', 10000),
	('CDSP10026', 'SP1002', N'Đóng gói', N'Đóng gói', 30000);


--HopDongTable
INSERT INTO [HopDong] (maHD,tenKH,sDT,diaChi,email,ngayKKHD,ngayTLHD,trangThaiHD)
VALUES
    ('HD100000', N'Kalia Mcdaniel','0900856716','Ap #880-5637 Maecenas Ave','phasellus.at@gmail.com','2022-11-27','2024-01-31','0'),
    ('HD100001', N'Oliver Monroe','0901130683','189-9031 Scelerisque, Road','felis.ullamcorper@gmail.com','2023-01-04','2024-04-26','0'),
    ('HD100002', N'Cameron Cotton','0386142383','P.O. Box 954, 5519 Odio Road','et.ultrices.posuere@gmail.com','2022-11-18','2024-04-29','0');


--ChiTietHopDongTable
INSERT INTO [ChiTietHopDong] (maHD,maSP,soLuongDat, soLuongDaLam)
VALUES
    ('HD100000','SP1000', 1000, 0),
    ('HD100000','SP1001', 500, 0),
    ('HD100001','SP1001', 300, 0),
    ('HD100001','SP1002', 100, 0),
    ('HD100002','SP1002', 300, 0),
    ('HD100002','SP1000', 400, 0);


--ToSanXuatTable
INSERT INTO [ToSanXuat] (maTSX, tenTSX)
VALUES
    ('TSX001', N'Tổ 1'),
    ('TSX002', N'Tổ 2'),
    ('TSX003', N'Tổ 3'),
    ('TSX004', N'Tổ 4');


--NhanVienTable
INSERT INTO [NhanVien] (maNV,maPB,maCV,maPhuCap,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,luongCoBan)
VALUES
    ('NV100000','PBHCQL','CVNVQL','PCNV01',N'Nguyễn Văn',N'Giàu','1','1974-02-19','5223275971','iaculis@gmail.com','2023-12-9','4929768247276589',7000000),
    ('NV100001','PBHCQL','CVNVQL','PCNV02',N'Hồ Tấn',N'Lộc','0','1971-12-30','0482440333','vitae.dolor@gmail.com','2023-11-13','4513 5696 3233 9822',7000000),
    ('NV100002','PBHCNS','CVNVHC','PCNV03',N'Nguyễn Văn',N'Nicole','1','1987-01-15','1798595223','libero.proin.mi@gmail.com','2024-08-6','527929 3467156661',5000000),
	('NV100003','PBHCNS','CVNVHC','PCNV01',N'Hồ Tấn',N'Minh','0','1974-02-19','5223275971','iaculis@gmail.com','2023-12-9','4929768247276589',5000000),
    ('NV100004','PBHCNS','CVNVHC','PCNV02',N'Đào Đức',N'Mạnh','0','1971-12-30','0482440333','vitae.dolor@gmail.com','2023-11-13','4513 5696 3233 9822',5000000),
    ('NV100005','PBHCNS','CVNVHC','PCNV03',N'Nguyễn Văn',N'Nicole','1','1987-01-15','1798595223','libero.proin.mi@gmail.com','2024-08-6','527929 3467156661',5000000),
	('NV100006','PBHCNS','CVNVHC','PCNV01',N'Trần Văn',N'Kelly','0','1974-02-19','5223275971','iaculis@gmail.com','2023-12-9','4929768247276589',5000000),
    ('NV100007','PBHCNS','CVNVHC','PCNV02',N'Nguyễn Văn',N'T','0','1971-12-30','0482440333','vitae.dolor@gmail.com','2023-11-13','4513 5696 3233 9822',5000000),
    ('NV100008','PBHCNS','CVNVHC','PCNV03',N'Nguyễn Thị Yến',N'N','1','1987-01-15','1798595223','libero.proin.mi@gmail.com','2024-08-6','527929 3467156661',5000000),
	('NV100009','PBHCNS','CVNVHC','PCNV01',N'Hồ Tấn',N'K','0','1974-02-19','5223275971','iaculis@gmail.com','2023-12-9','4929768247276589',5000000),
    ('NV100010','PBHCTC','CVNVKT','PCNV02',N'Nguyễn Văn',N'C','0','1971-12-30','0482440333','vitae.dolor@gmail.com','2023-11-13','4513 5696 3233 9822',6000000),
    ('NV100011','PBHCTC','CVNVTT','PCNV03',N'Nguyễn Văn',N'B','1','1987-01-15','1798595223','libero.proin.mi@gmail.com','2024-08-6','527929 3467156661',3000000);

--CongNhanTable
INSERT INTO [CongNhan] (maCN,maCV,maTSX,maPhuCap,hoCN,tenCN,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK)
VALUES
    ('CN100000','CVCNQL','TSX001','PCCN02','Rodriguez','Brielle','1','1990-03-26','0937182214','tincidunt.dui@gmail.com','May 24, 2012','4929327986896287'),
    ('CN100001','CVCNQL','TSX001','PCCN02','Bryan','Alika','1','1999-01-03','0316051570','donec@gmail.com','Apr 26, 2014','4532365131828'),
    ('CN100002','CVCNSX','TSX001','PCCN03','Kane','Demetria','0','1992-09-10','0799278866','libero.at@gmail.com','Feb 2, 2015','4532425883363788'),
    ('CN100003','CVCNSX','TSX001','PCCN01','Olson','Alexandra','0','1992-05-18','0824895831','erat.vivamus@gmail.com','Jul 20, 2008','4122541464884335'),
    ('CN100004','CVCNSX','TSX001','PCCN03','Boyer','Ralph','1','1997-09-19','0946429884','diam.nunc@gmail.com','Aug 28, 2019','4485746889491'),
    ('CN100005','CVCNSX','TSX001','PCCN01','Caldwell','Maggie','0','1999-02-21','0706764457','sed.tortor@gmail.com','Jun 15, 2015','4225345324238278'),
    ('CN100006','CVCNSX','TSX001','PCCN01','Walls','Delilah','1','1993-02-18','0940216936','nulla.dignissim@gmail.com','Jun 24, 2011','4024007127679'),
    ('CN100007','CVCNSX','TSX001','PCCN02','Bender','Erich','0','2004-01-20','0936544652','lacinia@gmail.com','Oct 7, 2006','4485582454514772'),
    ('CN100008','CVCNSX','TSX001','PCCN02','Humphrey','Len','0','1994-09-24','0846401318','pede.blandit.congue@gmail.com','Mar 19, 2008','4485228748413'),
    ('CN100009','CVCNSX','TSX001','PCCN03','Rasmussen','Aquila','0','1994-07-06','0334631208','justo@gmail.com','Aug 24, 2012','4485468265688635'),
    ('CN100010','CVCNSX','TSX002','PCCN03','Mosley','Graham','0','1994-01-22','0774157213','elementum.dui@gmail.com','Oct 31, 2022','4532664923654554'),
    ('CN100011','CVCNSX','TSX002','PCCN01','Murphy','Raven','1','1993-01-10','0355212858','risus.morbi@gmail.com','Dec 18, 2019','4865658865441'),
    ('CN100012','CVCNSX','TSX002','PCCN02','Hines','Beck','0','1984-08-13','0872866546','suspendisse.tristique@gmail.com','Jul 22, 2008','4485924769434488'),
    ('CN100013','CVCNSX','TSX002','PCCN03','Downs','Chiquita','1','1987-05-20','0803870398','lobortis@gmail.com','Dec 23, 2005','4916521879596'),
    ('CN100014','CVCNSX','TSX002','PCCN03','Garrison','Charlotte','0','2003-06-01','0758936829','nec.mauris.blandit@gmail.com','Sep 26, 2019','4556447753424'),
    ('CN100015','CVCNSX','TSX002','PCCN01','Bray','Ira','1','1987-11-06','0376738986','lobortis.augue@gmail.com','Nov 22, 2009','4532954551899'),
    ('CN100016','CVCNSX','TSX002','PCCN03','Black','Arsenio','0','1997-02-06','0338508675','in.at.pede@gmail.com','Sep 7, 2009','4716162443268'),
    ('CN100017','CVCNSX','TSX002','PCCN01','Marsh','Cole','0','1994-05-10','0743726678','velit@gmail.com','Jul 2, 2006','4024007164789'),
    ('CN100018','CVCNSX','TSX002','PCCN01','Rowe','Penelope','1','1988-12-05','0756281644','consectetuer@gmail.com','Mar 28, 2016','4556722452338'),
    ('CN100019','CVCNSX','TSX002','PCCN02','Snow','Kasper','1','1990-11-17','0839720313','nulla@gmail.com','Sep 28, 2008','4532892115741471'),
    ('CN100020','CVCNSX','TSX003','PCCN02','Slater','Nerea','1','1985-11-19','0313856751','facilisis.magna@gmail.com','Oct 22, 2011','4485945781131166'),
    ('CN100021','CVCNSX','TSX003','PCCN01','Nunez','Barclay','1','2003-12-24','0985842912','integer.eu.lacus@gmail.com','Sep 8, 2007','4184548345253'),
    ('CN100022','CVCNSX','TSX003','PCCN02','Cleveland','Hamish','1','1984-10-26','0792344657','fringilla@gmail.com','Aug 23, 2009','4532922767270'),
    ('CN100023','CVCNSX','TSX003','PCCN01','Finley','Jonah','0','1988-09-13','0377724840','ut.pharetra@gmail.com','Oct 22, 2009','4539876545511'),
    ('CN100024','CVCNSX','TSX003','PCCN03','Edwards','John','1','1982-12-23','0845584279','in.magna@gmail.com','Aug 9, 2012','4539243815853187'),
    ('CN100025','CVCNSX','TSX003','PCCN02','Quinn','Helen','1','1985-08-19','0375286762','sit.amet.nulla@gmail.com','Nov 29, 2016','4716288861252'),
    ('CN100026','CVCNSX','TSX003','PCCN01','Meadows','Tana','1','1986-06-09','0976414909','fringilla.ornare@gmail.com','Mar 10, 2012','4532475848333665'),
    ('CN100027','CVCNSX','TSX004','PCCN03','Head','Patricia','0','2001-01-12','0808578361','ac.tellus.suspendisse@gmail.com','May 8, 2021','4916236811649859'),
    ('CN100028','CVCNSX','TSX004','PCCN03','Price','Magee','0','1988-08-17','0768306174','venenatis.lacus.etiam@gmail.com','Mar 21, 2019','4929617278254348'),
    ('CN100029','CVCNSX','TSX004','PCCN01','Larsen','Bianca','0','1991-07-17','0833136702','primis.in@gmail.com','Aug 25, 2014','4024007159382620');

INSERT INTO [CongNhan] (maCN,maCV,maTSX,maPhuCap,hoCN,tenCN,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,trangThaiCN)
VALUES
    ('CN100100','CVCNSX','TSX004','PCCN02','Yates','Knox','0','1999-04-24','0351407605','arcu.iaculis@gmail.com','Dec 10, 2006','4539727125568238','1'),
    ('CN100101','CVCNSX','TSX004','PCCN01','Dominguez','Amanda','1','2002-06-21','0961747075','sed.est@gmail.com','Dec 22, 2007','4716896363478692','1');

INSERT INTO [TaiKhoan] (maTK, matKhau, vaiTro, trangThaiTK)
VALUES	('NV100000', '123456', N'Quản lý hành chính', '1'),
		('NV100001', '123456',	N'Kế toán',	'1'),
		('NV100002', '123456',	N'Quản lý sản xuất', '1');