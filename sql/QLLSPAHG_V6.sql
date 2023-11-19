--Kiem tra cds co ton tai hay khong?
USE master
DROP DATABASE IF EXISTS QLLSPAHG
GO
--Tao csdl moi
CREATE DATABASE QLLSPAHG
GO

USE QLLSPAHG
GO

--Table PhongBan
CREATE TABLE PhongBan(
                         maPB varchar(6) NOT NULL, --khoa chinh
                         tenPB nvarchar(50),

                         CONSTRAINT PK_PhongBan PRIMARY KEY(maPB)
)

--Table NhanVien
CREATE TABLE NhanVien(
                         maNV varchar(8) NOT NULL, --khoa chinh
                         maPB varchar(6), --khoa ngoai
                         maCV varchar(6), --khoa ngoai
                         maPhuCap varchar(6), --khoa ngoai
                         hoNV nvarchar(64),
                         tenNV nvarchar(32),
                         gioiTinh bit DEFAULT 0,  --0 la nam, 1 la nu
                         ngaySinh date,
                         sDT varchar(10),
                         email varchar(128),
                         ngayVaoLam date,
                         sTK varchar(20),
                         luongCoBan numeric(19, 4),
                         trangThaiNV bit DEFAULT 0, -- 0 la hoat dong, 1 la khong hoat dong

                         CONSTRAINT PK_NhanVien PRIMARY KEY(maNV)
)
    GO
--Table TaiKhoan
CREATE TABLE TaiKhoan(
                         maTK varchar(8), --khoa ngoai --khoa chinh
                         matKhau varchar(max),
trangThaiTK bit DEFAULT 0, -- 0 la hoat dong, 1 la khong hoat dong

CONSTRAINT PK_TaiKhoan PRIMARY KEY CLUSTERED(maTK)
)

--Table ChucVu
CREATE TABLE ChucVu(
                       maCV varchar(6) NOT NULL, --khoa chinh
                       tenCV nvarchar(32),
                       heSoCV float(1),

                       CONSTRAINT PK_ChucVu PRIMARY KEY(maCV)
)

--Table CongNhan
CREATE TABLE CongNhan(
                         maCN varchar(8) NOT NULL, --khoa chinh
                         maCV varchar(6), --khoa ngoai
                         maTSX varchar(6), --khoa ngoai
                         maPhuCap varchar(6), --khoa ngoai
                         hoCN nvarchar(32),
                         tenCN nvarchar(32),
                         gioiTinh bit DEFAULT 1,
                         ngaySinh date,
                         sDT varchar(10),
                         email varchar(128),
                         ngayVaoLam date,
                         sTK varchar(20),
                         trangThaiNV bit DEFAULT 0, -- 0 la hoat dong, 1 la khong hoat dong

                         CONSTRAINT PK_CongNhan PRIMARY KEY(maCN)
)

--Table ToSanXuat
CREATE TABLE ToSanXuat(
                          maTSX varchar(6) NOT NULL, --khoa chinh
                          tenTSX nvarchar(32),

                          CONSTRAINT PK_ToSanXuat PRIMARY KEY(maTSX)
)

--Table HopDong
CREATE TABLE HopDong(
                        maHD varchar(8) NOT NULL, --khoa chinh
                        tenKH nvarchar(64),
                        sDT varchar(10),
                        diaChi nvarchar(max),
                        email varchar(128),
                        ngayKKHD date,
                        ngayTLHD date,
                        trangThaiHD bit DEFAULT 0, --0 chua thanh ly, 1 la thanh 

                        CONSTRAINT PK_HopDong PRIMARY KEY(maHD)
)

--Table ChiTietHopDong
CREATE TABLE ChiTietHopDong(
                               maHD varchar(8), --khoa ngoai --khoa chinh
                               maSP varchar(6), --khoa ngoai --khoa chinh
                               soLuongDat int,
							   soLuongDaLam int,

                               CONSTRAINT PK_ChiTietHopDong PRIMARY KEY(maHD, maSP)
)


--Table SanPham
CREATE TABLE SanPham(
                        maSP varchar(6) NOT NULL, --khoa chinh
                        tenLoai nvarchar(32),
                        tenSP nvarchar(128),
                        giaSP decimal(19, 4),
                        trangThaiSP bit DEFAULT 0, --0 sp duoc lay len, 1 san pham da bi xoa

                        CONSTRAINT PK_SanPham PRIMARY KEY(maSP)
)


--Table CongDoan
CREATE TABLE CongDoan(
                         maCD varchar(9) NOT NULL, --khoa chinh CD+ Ma San Pham + *(1 so )
                         maSP varchar(6), --khoa ngoai
                         tenCD nvarchar(32),
						 giaiDoan nvarchar(32),
                         giaCongDoan decimal(19, 4)

                         CONSTRAINT PK_CongDoan PRIMARY KEY(maCD)
)

--Table BangPhanCongCongNhan
CREATE TABLE BangPhanCongCongNhan(
                                     maBPCCN varchar(14) NOT NULL, --khoa chinh
                                     maCN varchar(8), --khoa ngoai
                                     maCD varchar(9), --khoa ngoai
									 maHD varchar(8), --khoa ngoai
                                     chiTieu int,
                                     ngayPhanCong date,
                                     ngayKetThuc date,

                                     CONSTRAINT PK_BangPhanCongCongNhan PRIMARY KEY(maBPCCN)
)

--Table BangChamCongCongNhan
CREATE TABLE BangChamCongCongNhan(
                                     maBCCCN varchar(14) NOT NULL, --khoa chinh
                                     maBPCCN varchar(14), --khoa ngoai
                                     ngayChamCong date,
                                     soLuongLamDuoc int,
                                     soLuongLamCa3 int,
                                     nghiPhep bit DEFAULT 1, --0 la khong phep, 1 la co phep

                                     CONSTRAINT PK_BangChamCongCongNhan PRIMARY KEY(maBCCCN)
)

--Table BangPhanCongNhanVien
--CREATE TABLE BangPhanCongNhanVien(
--maBPCNV varchar(6) NOT NULL, --khoa chinh
--maNV varchar(8), --khoa ngoai
--maCa varchar(6), --khoa ngoai
--ngayBatDau date,
--ngayKetThuc date,

--CONSTRAINT PK_BangPhanCongNhanVien PRIMARY KEY(maBPCNV)
--)


--Table BangChamCongNhanVien
CREATE TABLE BangChamCongNhanVien(
                                     maBCCNV varchar(14) NOT NULL, --khoa chinh
                                     maNV varchar(8), --khoa ngoai khoa chinh
                                     ngayChamCong date,
                                     diLam bit DEFAULT 1, --0 la khong di lam, 1 la co di lam
                                     nghiPhep bit DEFAULT 0, --0 la khong phep, 1 la co phep
                                     tangCa bit DEFAULT 0, --0 la khong tang ca, 1 la co tang ca

                                     CONSTRAINT PK_BangChamCongNhanVien PRIMARY KEY (maBCCNV)
)

--Table TamUngNhanVien
CREATE TABLE TamUngNhanVien(
                               maTUNV varchar(6) NOT NULL, --khoa chinh
                               ngayTamUng date,
                               lyDo nvarchar(max),
                               soTienTamUng decimal(19, 4),

                               CONSTRAINT PK_TamUngNhanVien PRIMARY KEY(maTUNV)
)


--Table BangLuongNhanVien
CREATE TABLE BangLuongNhanVien(
                                  maBCCNV varchar(14), --khoa ngoai --
                                  maTUNV varchar(6), --khoa ngoai --khoa chinh
                                  luongNV decimal(19, 4),
                                  bhxhNV decimal(19, 4),
                                  bhytNV decimal(19, 4),
                                  tongLuongNV decimal(19, 4),
                                  ngayTinhLuong date,

                                  CONSTRAINT PK_BangLuongNhanVien PRIMARY KEY CLUSTERED(maBCCNV, maTUNV)
)

--Table PhuCap
CREATE TABLE PhuCap(
                       maPhuCap varchar(6) NOT NULL, --khoa chinh
                       tienChuyenCan decimal(19, 4),
                       tienNangSuat decimal(19, 4),
                       tienConNho decimal(19, 4),
                       tienDiLai decimal(19, 4),
                       tienNhaTro decimal(19, 4),
                       tienDienThoai decimal(19, 4),

                       CONSTRAINT PK_PhuCap PRIMARY KEY(maPhuCap)
)

--Table TamUngCongNhan
CREATE TABLE TamUngCongNhan(
                               maTUCN varchar(6) NOT NULL, --khoa chinh
                               ngayTamUng date,
                               lyDo nvarchar(max),
                               soTienTamUng decimal(19, 4),

                               CONSTRAINT PK_TamUngCongNhan PRIMARY KEY(maTUCN)
)

--Table BangLuongCongNhan
CREATE TABLE BangLuongCongNhan(
                                  maBCCCN varchar(14), --khoa ngoai --khoa chinh
                                  maTUCN varchar(6), --khoa ngoai --khoa chinh
                                  luongCN decimal(19, 4),
                                  bhxhCN decimal(19, 4),
                                  bhytCN decimal(19, 4),
                                  tongLuongCN decimal(19, 4),
                                  ngayTinhLuong date,

                                  CONSTRAINT PK_BangLuongCongNhan PRIMARY KEY CLUSTERED(maBCCCN, maTUCN)
)



--Tao khoa ngoai
ALTER TABLE TaiKhoan ADD CONSTRAINT FK01_TaiKhoan FOREIGN KEY (maTK) REFERENCES NhanVien(maNV)

ALTER TABLE NhanVien ADD CONSTRAINT FK01_NhanVien FOREIGN KEY (maPB) REFERENCES PhongBan(maPB)
ALTER TABLE NhanVien ADD CONSTRAINT FK02_NhanVien FOREIGN KEY (maCV) REFERENCES ChucVu(maCV)

ALTER TABLE CongNhan ADD CONSTRAINT FK01_CongNhan FOREIGN KEY (maCV) REFERENCES ChucVu(maCV)
ALTER TABLE CongNhan ADD CONSTRAINT FK02_CongNhan FOREIGN KEY (maTSX) REFERENCES ToSanXuat(maTSX)

ALTER TABLE ChiTietHopDong ADD CONSTRAINT FK01_ChiTietHopDong FOREIGN KEY (maHD) REFERENCES HopDong(maHD)
ALTER TABLE ChiTietHopDong ADD CONSTRAINT FK02_ChiTiethopDong FOREIGN KEY (maSP) REFERENCES SanPham(maSP)

ALTER TABLE CongDoan ADD CONSTRAINT FK01_CongDoan FOREIGN KEY (maSP) REFERENCES SanPham(maSP)

ALTER TABLE NhanVien ADD CONSTRAINT FK03_NhanVien FOREIGN KEY (maPhucap) REFERENCES PhuCap(maPhuCap)
ALTER TABLE CongNhan ADD CONSTRAINT FK03_CongNhan FOREIGN KEY (maPhucap) REFERENCES PhuCap(maPhuCap)

ALTER TABLE BangPhanCongCongNhan ADD CONSTRAINT FK01_BangPhanCongCongNhan FOREIGN KEY (maCN) REFERENCES CongNhan(maCN)
ALTER TABLE BangPhanCongCongNhan ADD CONSTRAINT FK02_BangPhanCongCongNhan FOREIGN KEY (maCD) REFERENCES CongDoan(maCD)
ALTER TABLE BangPhanCongCongNhan ADD CONSTRAINT FK03_BangPhanCongCongNhan FOREIGN KEY (maHD) REFERENCES HopDong(maHD)

ALTER TABLE BangChamCongCongNhan ADD CONSTRAINT FK01_BangChamCongCongNhan FOREIGN KEY (maBPCCN) REFERENCES BangPhanCongCongNhan(maBPCCN)

ALTER TABLE BangChamCongNhanVien ADD CONSTRAINT FK01_BangChamCongNhanVien FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)

ALTER TABLE BangLuongNhanVien ADD CONSTRAINT FK01_BangLuongNhanVien FOREIGN KEY (maBCCNV) REFERENCES BangChamCongNhanVien(maBCCNV)
ALTER TABLE BangLuongNhanVien ADD CONSTRAINT FK02_BangLuongNhanVien FOREIGN KEY (maTUNV) REFERENCES TamUngNhanVien(maTUNV)

ALTER TABLE BangLuongCongNhan ADD CONSTRAINT FK01_BangLuongCongNhan FOREIGN KEY (maBCCCN) REFERENCES BangChamCongCongNhan(maBCCCN)
ALTER TABLE BangLuongCongNhan ADD CONSTRAINT FK02_BangLuongCongNhan FOREIGN KEY (maTUCN) REFERENCES TamUngCongNhan(maTUCN)
    GO

USE master
GO
