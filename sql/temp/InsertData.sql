INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) 
VALUES 
  (N 'HD011123', N 'SP9204', 22) INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) 
VALUES 
  (N 'HD011123', N 'SP9205', 55) INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) 
VALUES 
  (N 'HD121023', N 'SP9205', 111) INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) 
VALUES 
  (N 'HD121023', N 'SP9207', 666) INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) 
VALUES 
  (N 'HD121023', N 'SP9208', 11) INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) 
VALUES 
  (N 'HD191023', N 'SP9205', 55) GO INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) 
VALUES 
  (
    N 'CNQL01', N 'Quan Li Cong Nhan 01', 
    1.2
  ) INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) 
VALUES 
  (
    N 'CNQL02', N 'Quan Li Cong Nhan 02', 
    1.2
  ) INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) 
VALUES 
  (
    N 'CNTT03', N 'Cong Nhan To Truong', 
    1.1
  ) INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) 
VALUES 
  (
    N 'NVHC01', N 'Nhan Vien Hanh Chinh 01', 
    1
  ) INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) 
VALUES 
  (
    N 'NVHC02', N 'Nhan Vien Hanh Chinh 02', 
    1
  ) INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) 
VALUES 
  (
    N 'NVKT01', N 'Nhan Vien Ke Toan', 
    1.1
  ) INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) 
VALUES 
  (
    N 'NVQL01', N 'Quan Li Hanh Chinh', 
    1.2
  ) GO INSERT [dbo].[HopDong] (
    [maHD], [tenKH], [sDT], [diaChi], [email], 
    [ngayKKHD], [ngayTLHD], [trangThaiHD]
  ) 
VALUES 
  (
    N 'HD011123', 
    N 'Nguyen Van Giau', 
    N '0901410087', 
    N 'Ho Chi Minh', 
    N 'jiag293@gmail.com', 
    CAST(
      N '2023-10-30T00:00:00' AS SmallDateTime
    ), 
    CAST(
      N '2023-11-03T00:00:00' AS SmallDateTime
    ), 
    0
  ) INSERT [dbo].[HopDong] (
    [maHD], [tenKH], [sDT], [diaChi], [email], 
    [ngayKKHD], [ngayTLHD], [trangThaiHD]
  ) 
VALUES 
  (
    N 'HD121023', 
    N 'Ngo Thai Thien Vy', 
    N '1231354351', 
    N 'lorem isum', 
    N 'ngothaithienvy@gmail.com', 
    CAST(
      N '2023-10-12T00:00:00' AS SmallDateTime
    ), 
    CAST(
      N '2023-11-23T00:00:00' AS SmallDateTime
    ), 
    0
  ) INSERT [dbo].[HopDong] (
    [maHD], [tenKH], [sDT], [diaChi], [email], 
    [ngayKKHD], [ngayTLHD], [trangThaiHD]
  ) 
VALUES 
  (
    N 'HD191023', 
    N 'Ho Tan Loc', 
    N '1234566790', 
    N 'Long An', 
    N 'hotanloc@gmail.com', 
    CAST(
      N '2023-10-19T00:00:00' AS SmallDateTime
    ), 
    CAST(
      N '2023-11-13T00:00:00' AS SmallDateTime
    ), 
    0
  ) GO INSERT [dbo].[NhanVien] (
    [maNV], [maPB], [maCV], [maPhuCap], 
    [hoNV], [tenNV], [gioiTinh], [ngaySinh], 
    [sDT], [email], [ngayVaoLam], [sTK]
  ) 
VALUES 
  (
    N '19430481', 
    N 'PB0012', 
    N 'NVKT01', 
    N 'PC2002', 
    N 'Ngo Thai Thien', 
    N 'Vy', 
    1, 
    CAST(
      N '2001-09-02T00:00:00' AS SmallDateTime
    ), 
    N '2190291212', 
    N 'ngothaithienvy@gmail.com', 
    CAST(
      N '2023-10-20T00:00:00' AS SmallDateTime
    ), 
    N '3213131231'
  ) INSERT [dbo].[NhanVien] (
    [maNV], [maPB], [maCV], [maPhuCap], 
    [hoNV], [tenNV], [gioiTinh], [ngaySinh], 
    [sDT], [email], [ngayVaoLam], [sTK]
  ) 
VALUES 
  (
    N '20053331', 
    N 'PB0011', 
    N 'NVQL01', 
    N 'PC2002', 
    N 'Nguyen Van', 
    N 'Giau', 
    1, 
    CAST(
      N '2002-03-29T00:00:00' AS SmallDateTime
    ), 
    N '0901410087', 
    N 'jiag293@gmail.com', 
    CAST(
      N '2023-10-20T00:00:00' AS SmallDateTime
    ), 
    N '9090909090'
  ) INSERT [dbo].[NhanVien] (
    [maNV], [maPB], [maCV], [maPhuCap], 
    [hoNV], [tenNV], [gioiTinh], [ngaySinh], 
    [sDT], [email], [ngayVaoLam], [sTK]
  ) 
VALUES 
  (
    N '20063791', 
    N 'PB0013', 
    N 'NVKT01', 
    N 'PC2002', 
    N 'Ho Tan', 
    N 'Loc', 
    1, 
    CAST(
      N '2002-02-02T00:00:00' AS SmallDateTime
    ), 
    N '8218218282', 
    N 'hotanloc@gmail.com', 
    CAST(
      N '2003-02-23T00:00:00' AS SmallDateTime
    ), 
    N '2121212121'
  ) GO INSERT [dbo].[PhongBan] ([maPB], [tenPB]) 
VALUES 
  (N 'PB0011', N 'Phong Ke Toan') INSERT [dbo].[PhongBan] ([maPB], [tenPB]) 
VALUES 
  (N 'PB0012', N 'Phong Hanh Chinh') INSERT [dbo].[PhongBan] ([maPB], [tenPB]) 
VALUES 
  (N 'PB0013', N 'Phong Quan Li') GO INSERT [dbo].[PhuCap] (
    [maPhuCap], [tienChuyenCan], [tienNangSuat], 
    [tienConNho], [tienDiLai], [tienNhaTro], 
    [tienDienThoai]
  ) 
VALUES 
  (
    N 'PC2002', 
    CAST(
      150000.0000 AS Decimal(19, 4)
    ), 
    CAST(
      150000.0000 AS Decimal(19, 4)
    ), 
    CAST(
      100000.0000 AS Decimal(19, 4)
    ), 
    CAST(
      100000.0000 AS Decimal(19, 4)
    ), 
    CAST(
      100000.0000 AS Decimal(19, 4)
    ), 
    CAST(
      0.0000 AS Decimal(19, 4)
    )
  ) GO INSERT [dbo].[SanPham] (
    [maSP], [tenLoai], [tenSP], [giaSP]
  ) 
VALUES 
  (
    N 'SP9204', 
    N 'Balo 1', 
    N 'Balo 9204', 
    CAST(
      200000.0000 AS Decimal(19, 4)
    )
  ) INSERT [dbo].[SanPham] (
    [maSP], [tenLoai], [tenSP], [giaSP]
  ) 
VALUES 
  (
    N 'SP9205', 
    N 'Balo 2', 
    N 'Balo 9205', 
    CAST(
      350000.0000 AS Decimal(19, 4)
    )
  ) INSERT [dbo].[SanPham] (
    [maSP], [tenLoai], [tenSP], [giaSP]
  ) 
VALUES 
  (
    N 'SP9206', 
    N 'Balo 3', 
    N 'Balo 9206', 
    CAST(
      500000.0000 AS Decimal(19, 4)
    )
  ) INSERT [dbo].[SanPham] (
    [maSP], [tenLoai], [tenSP], [giaSP]
  ) 
VALUES 
  (
    N 'SP9207', 
    N 'Balo 4', 
    N 'Balo 9297', 
    CAST(
      190000.0000 AS Decimal(19, 4)
    )
  ) INSERT [dbo].[SanPham] (
    [maSP], [tenLoai], [tenSP], [giaSP]
  ) 
VALUES 
  (
    N 'SP9208', 
    N 'Balo 5', 
    N 'Balo 9208', 
    CAST(
      349990.0000 AS Decimal(19, 4)
    )
  ) GO INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) 
VALUES 
  (N '19430481', N '19430481') INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) 
VALUES 
  (N '20053331', N '20053331') INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) 
VALUES 
  (N '20063791', N '20063791') GO INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX001', N 'To San Xuat 01') INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX002', N 'To San Xuat 02') INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX003', N 'To San Xuat 03') INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX004', N 'To San Xuat 04') INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX005', N 'To San Xuat 05') INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX006', N 'To San Xuat 06') INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX007', N 'To San Xuat 07') INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX008', N 'To San Xuat 08') INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) 
VALUES 
  (N 'TSX009', N 'To San Xuat 09')
