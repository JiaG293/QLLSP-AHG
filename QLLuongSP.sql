create database QLLuongSP

use QLLuongSP
--table PhongBan-----------------------------------------------------------
create table PhongBan(
	maPB nvarchar(10) primary key,
	ten nvarchar(50)
)
-----------------------------------------------------------

--table NhanVien-----------------------------------------------------------
create table NhanVien(
	maNV nvarchar(10) not null,
	hoTen nvarchar(50),
	phai bit,
	ngaySinh date,
	ngayBatDau date,
	maPB nvarchar(10) not null,
	chucVu nvarchar(20)
)

alter table NhanVien
add constraint PK_maNV_maPB_NhanVien
primary key clustered (maNV, maPB)

alter table NhanVien
add constraint FK_maPB_NhanVien_PhongBan
foreign key (maPB) references PhongBan(maPB)
-----------------------------------------------------------

--table CongNhan-----------------------------------------------------------
create table CongNhan(
	maNV nvarchar(10) not null,
	maPB nvarchar(10) not null,
)

alter table CongNhan
add constraint PK_maNV_maPB_CongNhan
primary key (maNV, maPB)

alter table CongNhan
add constraint FK_maNV_maPB_CongNhan_NhanVien
foreign key (maNV, maPB) references NhanVien(maNV, maPB)
-----------------------------------------------------------

--table NhanVienHanhChinh-----------------------------------------------------------
create table NhanVienHanhChinh(
	maNV nvarchar(10) not null,
	maPB nvarchar(10) not null,
	trinhDoChuyenMon nvarchar(10),
	trinhDoNgoaiNgu nvarchar(100)
)

alter table NhanVienHanhChinh
add constraint PK_maNV_maPB_NhanVienHanhChinh
primary key clustered (maNV, maPB)

alter table NhanVienHanhChinh
add constraint FK_maNV_maPB_NhanVienHanhChinh_NhanVien
foreign key (maNV, maPB) references NhanVien(maNV, maPB)
-----------------------------------------------------------

--table HopDong-----------------------------------------------------------
create table HopDong(
	maHD nvarchar(10) not null primary key,
	ten nvarchar(50),
	khachHang nvarchar(50),
	ngayLap date,
	ngayThanhLy date,
	thoaThuan nvarchar(500)
)
-----------------------------------------------------------

--table SanPham-----------------------------------------------------------
create table SanPham(
	maSP nvarchar(10) not null primary key,
	ten nvarchar(50),
	donGia money,
	donViTinh nvarchar(10)
)
-----------------------------------------------------------

--table ChiTietHopDong-----------------------------------------------------------
create table ChiTietHopDong(
	maHD nvarchar(10) not null,
	maSP nvarchar(10) not null,
	soLuong int,
	yeuCau nvarchar(500)
)

alter table ChiTietHopDong
add constraint PK_maHD_maSP_ChiTietHopDong
primary key clustered (maHD, maSP)

alter table ChiTietHopDong
add constraint FK_maHD_ChiTietHopDong_HopDong
foreign key (maHD) references HopDong(maHD)

alter table ChiTietHopDong
add constraint FK_maSP_ChiTietHopDong_SanPham
foreign key (maSP) references SanPham(maSP) 
-----------------------------------------------------------

--table CongDoan-----------------------------------------------------------
create table CongDoan(
	maCD nvarchar(10) not null primary key,
	ten nvarchar(50),
	donGiaCongDoan money
)
-----------------------------------------------------------

--table ChiTietSanPham-----------------------------------------------------------
create table ChiTietSanPham(
	maSP nvarchar(10) not null,
	maCD nvarchar(10) not null
)

alter table ChiTietSanPham
add constraint PK_maSP_maCD_ChiTietSanPham
primary key clustered (maSP, maCD)

alter table ChiTietSanPham
add constraint FK_maSP_ChiTietSanPham_SanPham
foreign key (maSP) references SanPham(maSP)

alter table ChiTietSanPham
add constraint FK_maCD_ChiTietSanPham_CongDoan
foreign key (maCD) references CongDoan(maCD)
-----------------------------------------------------------

--table Ca-----------------------------------------------------------
create table Ca(
	maCa nvarchar(10) not null primary key,
	ten nvarchar(50)
)
-----------------------------------------------------------

--table BangChamCong-----------------------------------------------------------
create table BangChamCong(
	maBCC nvarchar(10) not null primary key,
	ngayLap date
)
-----------------------------------------------------------

--table BangChamCongCongNhan-----------------------------------------------------------
create table BangChamCongCongNhan(
	maBCC nvarchar(10) not null,
	maNV nvarchar(10) not null,
	maPB nvarchar(10) not null
)

alter table BangChamCongCongNhan
add constraint PK_maBCC_maNV_maPB_BangChamCongCongNhan
primary key clustered (maBCC, maNV, maPB)

alter table BangChamCongCongNhan
add constraint FK_maBCC_BangChamCongCongNhan_BangChamCong
foreign key (maBCC) references BangChamCong(maBCC)

alter table BangChamCongCongNhan
add constraint FK_maNV_maPB_BangChamCongCongNhan_CongNhan
foreign key (maNV, maPB) references CongNhan(maNV, maPB)
-----------------------------------------------------------

--table BangChamCongNhanVienHanhChinh-----------------------------------------------------------
create table BangChamCongNhanVienHanhChinh(
	maBCC nvarchar(10) not null,
	maNV nvarchar(10) not null,
	maPB nvarchar(10) not null
)

alter table BangChamCongNhanVienHanhChinh
add constraint PK_maBCC_maNV_maPB_BangChamCongNhanVienHanhChinh
primary key clustered (maBCC, maNV, maPB)

alter table BangChamCongNhanVienHanhChinh
add constraint FK_maBCC_BangChamCongNhanVienHanhChinh_BangChamCong
foreign key (maBCC) references BangChamCong(maBCC)

alter table BangChamCongNhanVienHanhChinh
add constraint FK_maNV_maPB_BangChamCongNhanVienHanhChinh_NhanVienHanhChinh
foreign key (maNV, maPB) references NhanVienHanhChinh(maNV, maPB)
-----------------------------------------------------------

--table ChiTietChamCongCongNhan
create table ChiTietChamCongCongNhan(
	maBCC nvarchar(10) not null,
	maNV nvarchar(10) not null,
	maPB nvarchar(10) not null,
	maSP nvarchar(10) not null,
	maCD nvarchar(10) not null,
	soLuong int,
	maCa nvarchar(10) not null
)

alter table ChiTietChamCongCongNhan
add constraint PK_maBCC_maNV_maSP_maCD_maCa_maPB_ChiTietChamCongCongNhan
primary key clustered (maBCC, maNV, maSP, maCD, maCa, maPB)

alter table ChiTietChamCongCongNhan
add constraint FK_maBCC_maNV_maPB_ChiTietChamCongCongNhan_BangChamCongCongNhan
foreign key (maBCC, maNV, maPB) references BangChamCongCongNhan(maBCC, maNV, maPB)

alter table ChiTietChamCongCongNhan
add constraint FK_maSP_maCD_ChiTietChamCongCongNhan_ChiTietSanPham
foreign key (maSP, maCD) references ChiTietSanPham(maSP, maCD)

alter table ChiTietChamCongCongNhan
add constraint FK_maCa_ChiTietChamCongCongNhan_Ca
foreign key (maCa) references Ca(maCa)
-----------------------------------------------------------

--table ChiTietChamCongNhanVienHanhChinh-----------------------------------------------------------
create table ChiTietChamCongNhanVienHanhChinh(
	maBCC nvarchar(10) not null,
	maNV nvarchar(10) not null,
	maPB nvarchar(10) not null,
	heSoLuong float,
	hienDien bit,
	tangCa bit
)

alter table ChiTietChamCongNhanVienHanhChinh
add constraint PK_maBCC_maNV_maPB_ChiTietChamCongNhanVienHanhChinh
primary key clustered (maBCC, maNV, maPB)

alter table ChiTietChamCongNhanVienHanhChinh
add constraint FK_maBCC_maNV_maPB_ChiTietChamCongNhanVienHanhChinh_BangChamCongNhanVienHanhChinh
foreign key (maBCC, maNV, maPB) references BangChamCongNhanVienHanhChinh(maBCC, maNV, maPB)
-----------------------------------------------------------

--table BangLuong-----------------------------------------------------------
create table BangLuong(
	maBL nvarchar(10) not null primary key,
	tongLuong money
)
-----------------------------------------------------------

--table BangLuongCongNhan-----------------------------------------------------------
create table BangLuongCongNhan(
	maBL nvarchar(10) not null,
	tongLuong money,
	maBCC nvarchar(10) not null,
	maNV nvarchar(10) not null,
	maPB nvarchar(10) not null,
)

alter table BangLuongCongNhan
add constraint PK_maBL_maBCC_maNV_maPB_BangLuongCongNhan
primary key clustered (maBL, maBCC, maNV, maPB)

alter table BangLuongCongNhan
add constraint FK_maBL_BangLuongCongNhan_BangLuong
foreign key (maBL) references BangLuong(maBL) 

alter table BangLuongCongNhan
add constraint FK_maBCC_maNV_maPB_BangLuongCongNhan_BangChamCongCongNhan
foreign key (maBCC, maNV, maPB) references BangChamCongCongNhan(maBCC, maNV, maPB)
-----------------------------------------------------------

--table BangLuongNhanVienHanhChinh-----------------------------------------------------------
create table BangLuongNhanVienHanhChinh(
	maBL nvarchar(10) not null,
	tongLuong money,
	maBCC nvarchar(10) not null,
	maNV nvarchar(10) not null,
	maPB nvarchar(10) not null,
)

alter table BangLuongNhanVienHanhChinh
add constraint FK_maBL_maBCC_maNV_maPB_BangLuongNhanVienHanhChinh
primary key clustered (maBL, maBCC, maNV, maPB)

alter table BangLuongNhanVienHanhChinh
add constraint FK_maBL_BangLuongNhanVienHanhChinh_BangLuong
foreign key (maBL) references BangLuong(maBL)

alter table BangLuongNhanVienHanhChinh
add constraint FK_maBCC_maNV_maPB_BangLuongNhanVienHanhChinh_BangChamCongNhanVienHanhChinh
foreign key (maBCC, maNV, maPB) references BangChamCongNhanVienHanhChinh(maBCC, maNV, maPB)
-----------------------------------------------------------

