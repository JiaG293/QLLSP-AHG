USE [master]
GO
/****** Object:  Database [QLLSPAHG]    Script Date: 01/11/2023 12:19:33 CH ******/
CREATE DATABASE [QLLSPAHG]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLLSPAHG', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLLSPAHG.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLLSPAHG_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLLSPAHG_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLLSPAHG] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLLSPAHG].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLLSPAHG] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLLSPAHG] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLLSPAHG] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLLSPAHG] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLLSPAHG] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLLSPAHG] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLLSPAHG] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLLSPAHG] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLLSPAHG] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLLSPAHG] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLLSPAHG] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLLSPAHG] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLLSPAHG] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLLSPAHG] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLLSPAHG] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLLSPAHG] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLLSPAHG] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLLSPAHG] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLLSPAHG] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLLSPAHG] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLLSPAHG] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLLSPAHG] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLLSPAHG] SET RECOVERY FULL 
GO
ALTER DATABASE [QLLSPAHG] SET  MULTI_USER 
GO
ALTER DATABASE [QLLSPAHG] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLLSPAHG] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLLSPAHG] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLLSPAHG] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLLSPAHG] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLLSPAHG] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLLSPAHG', N'ON'
GO
ALTER DATABASE [QLLSPAHG] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLLSPAHG] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLLSPAHG]
GO
/****** Object:  User [20053331]    Script Date: 01/11/2023 12:19:33 CH ******/
CREATE USER [20053331] FOR LOGIN [20053331] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[BangChamCongCongNhan]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangChamCongCongNhan](
	[maBCCCN] [varchar](6) NOT NULL,
	[maBPCCN] [varchar](6) NULL,
	[ngayChamCong] [smalldatetime] NULL,
	[soLuongLamDuoc] [int] NULL,
	[soLuongLamCa3] [int] NULL,
	[nghiPhep] [bit] NULL,
 CONSTRAINT [PK_BangChamCongCongNhan] PRIMARY KEY CLUSTERED 
(
	[maBCCCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangChamCongNhanVien]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangChamCongNhanVien](
	[maBCCNV] [varchar](6) NOT NULL,
	[maNV] [varchar](8) NULL,
	[ngayChamCong] [smalldatetime] NULL,
	[diLam] [bit] NULL,
	[nghiPhep] [bit] NULL,
	[tangCa] [bit] NULL,
 CONSTRAINT [PK_BangChamCongNhanVien] PRIMARY KEY CLUSTERED 
(
	[maBCCNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangLuongCongNhan]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuongCongNhan](
	[maBCCCN] [varchar](6) NOT NULL,
	[maTUCN] [varchar](6) NOT NULL,
	[luongCN] [decimal](19, 4) NULL,
	[bhxhCN] [decimal](19, 4) NULL,
	[bhytCN] [decimal](19, 4) NULL,
	[tongLuongCN] [decimal](19, 4) NULL,
	[ngayTinhLuong] [smalldatetime] NULL,
 CONSTRAINT [PK_BangLuongCongNhan] PRIMARY KEY CLUSTERED 
(
	[maBCCCN] ASC,
	[maTUCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangLuongNhanVien]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuongNhanVien](
	[maBCCNV] [varchar](6) NOT NULL,
	[maTUNV] [varchar](6) NOT NULL,
	[luongNV] [decimal](19, 4) NULL,
	[bhxhNV] [decimal](19, 4) NULL,
	[bhytNV] [decimal](19, 4) NULL,
	[tongLuongNV] [decimal](19, 4) NULL,
	[ngayTinhLuong] [smalldatetime] NULL,
 CONSTRAINT [PK_BangLuongNhanVien] PRIMARY KEY CLUSTERED 
(
	[maBCCNV] ASC,
	[maTUNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangPhanCongCongNhan]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangPhanCongCongNhan](
	[maBPCCN] [varchar](6) NOT NULL,
	[maCN] [varchar](8) NULL,
	[maCD] [varchar](6) NULL,
	[chiTieu] [int] NULL,
	[ngayPhanCong] [smalldatetime] NULL,
	[ngayKetThuc] [smalldatetime] NULL,
 CONSTRAINT [PK_BangPhanCongCongNhan] PRIMARY KEY CLUSTERED 
(
	[maBPCCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHopDong]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHopDong](
	[maHD] [varchar](8) NOT NULL,
	[maSP] [varchar](6) NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_ChiTietHopDong] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[maCV] [varchar](6) NOT NULL,
	[tenCV] [nvarchar](32) NULL,
	[heSoCV] [real] NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[maCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongDoan]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongDoan](
	[maCD] [varchar](6) NOT NULL,
	[maSP] [varchar](6) NULL,
	[tenCD] [nvarchar](32) NULL,
	[giaCongDoan] [decimal](19, 4) NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_CongDoan] PRIMARY KEY CLUSTERED 
(
	[maCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongNhan]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongNhan](
	[maCN] [varchar](8) NOT NULL,
	[maCV] [varchar](6) NULL,
	[maTSX] [varchar](6) NULL,
	[maPhuCap] [varchar](6) NULL,
	[hoCN] [nvarchar](32) NULL,
	[tenCN] [nvarchar](32) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [smalldatetime] NULL,
	[sDT] [varchar](10) NULL,
	[email] [varchar](128) NULL,
	[ngayVaoLam] [smalldatetime] NULL,
	[sTK] [varchar](20) NULL,
 CONSTRAINT [PK_CongNhan] PRIMARY KEY CLUSTERED 
(
	[maCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDong](
	[maHD] [varchar](8) NOT NULL,
	[tenKH] [nvarchar](64) NULL,
	[sDT] [varchar](10) NULL,
	[diaChi] [nvarchar](max) NULL,
	[email] [varchar](128) NULL,
	[ngayKKHD] [smalldatetime] NULL,
	[ngayTLHD] [smalldatetime] NULL,
	[trangThaiHD] [bit] NULL,
 CONSTRAINT [PK_HopDong] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](8) NOT NULL,
	[maPB] [varchar](6) NULL,
	[maCV] [varchar](6) NULL,
	[maPhuCap] [varchar](6) NULL,
	[hoNV] [nvarchar](64) NULL,
	[tenNV] [nvarchar](32) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [smalldatetime] NULL,
	[sDT] [varchar](10) NULL,
	[email] [varchar](128) NULL,
	[ngayVaoLam] [smalldatetime] NULL,
	[sTK] [varchar](20) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongBan]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongBan](
	[maPB] [varchar](6) NOT NULL,
	[tenPB] [varchar](50) NULL,
 CONSTRAINT [PK_PhongBan] PRIMARY KEY CLUSTERED 
(
	[maPB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuCap]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuCap](
	[maPhuCap] [varchar](6) NOT NULL,
	[tienChuyenCan] [decimal](19, 4) NULL,
	[tienNangSuat] [decimal](19, 4) NULL,
	[tienConNho] [decimal](19, 4) NULL,
	[tienDiLai] [decimal](19, 4) NULL,
	[tienNhaTro] [decimal](19, 4) NULL,
	[tienDienThoai] [decimal](19, 4) NULL,
 CONSTRAINT [PK_PhuCap] PRIMARY KEY CLUSTERED 
(
	[maPhuCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSP] [varchar](6) NOT NULL,
	[tenLoai] [nvarchar](32) NULL,
	[tenSP] [nvarchar](128) NULL,
	[giaSP] [decimal](19, 4) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTK] [varchar](8) NOT NULL,
	[matKhau] [varchar](max) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TamUngCongNhan]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TamUngCongNhan](
	[maTUCN] [varchar](6) NOT NULL,
	[ngayTamUng] [smalldatetime] NULL,
	[lyDo] [nvarchar](max) NULL,
	[soTienTamUng] [decimal](19, 4) NULL,
 CONSTRAINT [PK_TamUngCongNhan] PRIMARY KEY CLUSTERED 
(
	[maTUCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TamUngNhanVien]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TamUngNhanVien](
	[maTUNV] [varchar](6) NOT NULL,
	[ngayTamUng] [smalldatetime] NULL,
	[lyDo] [nvarchar](max) NULL,
	[soTienTamUng] [decimal](19, 4) NULL,
 CONSTRAINT [PK_TamUngNhanVien] PRIMARY KEY CLUSTERED 
(
	[maTUNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ToSanXuat]    Script Date: 01/11/2023 12:19:33 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ToSanXuat](
	[maTSX] [varchar](6) NOT NULL,
	[tenTSX] [nvarchar](32) NULL,
 CONSTRAINT [PK_ToSanXuat] PRIMARY KEY CLUSTERED 
(
	[maTSX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) VALUES (N'HD011123', N'SP9204', 22)
INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) VALUES (N'HD011123', N'SP9205', 55)
INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) VALUES (N'HD121023', N'SP9205', 111)
INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) VALUES (N'HD121023', N'SP9207', 666)
INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) VALUES (N'HD121023', N'SP9208', 11)
INSERT [dbo].[ChiTietHopDong] ([maHD], [maSP], [soLuong]) VALUES (N'HD191023', N'SP9205', 55)
GO
INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) VALUES (N'CNQL01', N'Quan Li Cong Nhan 01', 1.2)
INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) VALUES (N'CNQL02', N'Quan Li Cong Nhan 02', 1.2)
INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) VALUES (N'CNTT03', N'Cong Nhan To Truong', 1.1)
INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) VALUES (N'NVHC01', N'Nhan Vien Hanh Chinh 01', 1)
INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) VALUES (N'NVHC02', N'Nhan Vien Hanh Chinh 02', 1)
INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) VALUES (N'NVKT01', N'Nhan Vien Ke Toan', 1.1)
INSERT [dbo].[ChucVu] ([maCV], [tenCV], [heSoCV]) VALUES (N'NVQL01', N'Quan Li Hanh Chinh', 1.2)
GO
INSERT [dbo].[HopDong] ([maHD], [tenKH], [sDT], [diaChi], [email], [ngayKKHD], [ngayTLHD], [trangThaiHD]) VALUES (N'HD011123', N'Nguyen Van Giau', N'0901410087', N'Ho Chi Minh', N'jiag293@gmail.com', CAST(N'2023-10-30T00:00:00' AS SmallDateTime), CAST(N'2023-11-03T00:00:00' AS SmallDateTime), 0)
INSERT [dbo].[HopDong] ([maHD], [tenKH], [sDT], [diaChi], [email], [ngayKKHD], [ngayTLHD], [trangThaiHD]) VALUES (N'HD121023', N'Ngo Thai Thien Vy', N'1231354351', N'lorem isum', N'ngothaithienvy@gmail.com', CAST(N'2023-10-12T00:00:00' AS SmallDateTime), CAST(N'2023-11-23T00:00:00' AS SmallDateTime), 0)
INSERT [dbo].[HopDong] ([maHD], [tenKH], [sDT], [diaChi], [email], [ngayKKHD], [ngayTLHD], [trangThaiHD]) VALUES (N'HD191023', N'Ho Tan Loc', N'1234566790', N'Long An', N'hotanloc@gmail.com', CAST(N'2023-10-19T00:00:00' AS SmallDateTime), CAST(N'2023-11-13T00:00:00' AS SmallDateTime), 0)
GO
INSERT [dbo].[NhanVien] ([maNV], [maPB], [maCV], [maPhuCap], [hoNV], [tenNV], [gioiTinh], [ngaySinh], [sDT], [email], [ngayVaoLam], [sTK]) VALUES (N'19430481', N'PB0012', N'NVKT01', N'PC2002', N'Ngo Thai Thien', N'Vy', 1, CAST(N'2001-09-02T00:00:00' AS SmallDateTime), N'2190291212', N'ngothaithienvy@gmail.com', CAST(N'2023-10-20T00:00:00' AS SmallDateTime), N'3213131231')
INSERT [dbo].[NhanVien] ([maNV], [maPB], [maCV], [maPhuCap], [hoNV], [tenNV], [gioiTinh], [ngaySinh], [sDT], [email], [ngayVaoLam], [sTK]) VALUES (N'20053331', N'PB0011', N'NVQL01', N'PC2002', N'Nguyen Van', N'Giau', 1, CAST(N'2002-03-29T00:00:00' AS SmallDateTime), N'0901410087', N'jiag293@gmail.com', CAST(N'2023-10-20T00:00:00' AS SmallDateTime), N'9090909090')
INSERT [dbo].[NhanVien] ([maNV], [maPB], [maCV], [maPhuCap], [hoNV], [tenNV], [gioiTinh], [ngaySinh], [sDT], [email], [ngayVaoLam], [sTK]) VALUES (N'20063791', N'PB0013', N'NVKT01', N'PC2002', N'Ho Tan', N'Loc', 1, CAST(N'2002-02-02T00:00:00' AS SmallDateTime), N'8218218282', N'hotanloc@gmail.com', CAST(N'2003-02-23T00:00:00' AS SmallDateTime), N'2121212121')
GO
INSERT [dbo].[PhongBan] ([maPB], [tenPB]) VALUES (N'PB0011', N'Phong Ke Toan')
INSERT [dbo].[PhongBan] ([maPB], [tenPB]) VALUES (N'PB0012', N'Phong Hanh Chinh')
INSERT [dbo].[PhongBan] ([maPB], [tenPB]) VALUES (N'PB0013', N'Phong Quan Li')
GO
INSERT [dbo].[PhuCap] ([maPhuCap], [tienChuyenCan], [tienNangSuat], [tienConNho], [tienDiLai], [tienNhaTro], [tienDienThoai]) VALUES (N'PC2002', CAST(150000.0000 AS Decimal(19, 4)), CAST(150000.0000 AS Decimal(19, 4)), CAST(100000.0000 AS Decimal(19, 4)), CAST(100000.0000 AS Decimal(19, 4)), CAST(100000.0000 AS Decimal(19, 4)), CAST(0.0000 AS Decimal(19, 4)))
GO
INSERT [dbo].[SanPham] ([maSP], [tenLoai], [tenSP], [giaSP]) VALUES (N'SP9204', N'Balo 1', N'Balo 9204', CAST(200000.0000 AS Decimal(19, 4)))
INSERT [dbo].[SanPham] ([maSP], [tenLoai], [tenSP], [giaSP]) VALUES (N'SP9205', N'Balo 2', N'Balo 9205', CAST(350000.0000 AS Decimal(19, 4)))
INSERT [dbo].[SanPham] ([maSP], [tenLoai], [tenSP], [giaSP]) VALUES (N'SP9206', N'Balo 3', N'Balo 9206', CAST(500000.0000 AS Decimal(19, 4)))
INSERT [dbo].[SanPham] ([maSP], [tenLoai], [tenSP], [giaSP]) VALUES (N'SP9207', N'Balo 4', N'Balo 9297', CAST(190000.0000 AS Decimal(19, 4)))
INSERT [dbo].[SanPham] ([maSP], [tenLoai], [tenSP], [giaSP]) VALUES (N'SP9208', N'Balo 5', N'Balo 9208', CAST(349990.0000 AS Decimal(19, 4)))
GO
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'19430481', N'19430481')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'20053331', N'20053331')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'20063791', N'20063791')
GO
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX001', N'To San Xuat 01')
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX002', N'To San Xuat 02')
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX003', N'To San Xuat 03')
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX004', N'To San Xuat 04')
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX005', N'To San Xuat 05')
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX006', N'To San Xuat 06')
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX007', N'To San Xuat 07')
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX008', N'To San Xuat 08')
INSERT [dbo].[ToSanXuat] ([maTSX], [tenTSX]) VALUES (N'TSX009', N'To San Xuat 09')
GO
ALTER TABLE [dbo].[BangChamCongCongNhan] ADD  DEFAULT ((1)) FOR [nghiPhep]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien] ADD  DEFAULT ((1)) FOR [diLam]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien] ADD  DEFAULT ((0)) FOR [nghiPhep]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien] ADD  DEFAULT ((0)) FOR [tangCa]
GO
ALTER TABLE [dbo].[CongNhan] ADD  DEFAULT ((1)) FOR [gioiTinh]
GO
ALTER TABLE [dbo].[HopDong] ADD  DEFAULT ((0)) FOR [trangThaiHD]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((1)) FOR [gioiTinh]
GO
ALTER TABLE [dbo].[BangChamCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK01_BangChamCongCongNhan] FOREIGN KEY([maBPCCN])
REFERENCES [dbo].[BangPhanCongCongNhan] ([maBPCCN])
GO
ALTER TABLE [dbo].[BangChamCongCongNhan] CHECK CONSTRAINT [FK01_BangChamCongCongNhan]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK01_BangChamCongNhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[BangChamCongNhanVien] CHECK CONSTRAINT [FK01_BangChamCongNhanVien]
GO
ALTER TABLE [dbo].[BangLuongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK01_BangLuongCongNhan] FOREIGN KEY([maBCCCN])
REFERENCES [dbo].[BangChamCongCongNhan] ([maBCCCN])
GO
ALTER TABLE [dbo].[BangLuongCongNhan] CHECK CONSTRAINT [FK01_BangLuongCongNhan]
GO
ALTER TABLE [dbo].[BangLuongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK02_BangLuongCongNhan] FOREIGN KEY([maTUCN])
REFERENCES [dbo].[TamUngCongNhan] ([maTUCN])
GO
ALTER TABLE [dbo].[BangLuongCongNhan] CHECK CONSTRAINT [FK02_BangLuongCongNhan]
GO
ALTER TABLE [dbo].[BangLuongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK01_BangLuongNhanVien] FOREIGN KEY([maBCCNV])
REFERENCES [dbo].[BangChamCongNhanVien] ([maBCCNV])
GO
ALTER TABLE [dbo].[BangLuongNhanVien] CHECK CONSTRAINT [FK01_BangLuongNhanVien]
GO
ALTER TABLE [dbo].[BangLuongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK02_BangLuongNhanVien] FOREIGN KEY([maTUNV])
REFERENCES [dbo].[TamUngNhanVien] ([maTUNV])
GO
ALTER TABLE [dbo].[BangLuongNhanVien] CHECK CONSTRAINT [FK02_BangLuongNhanVien]
GO
ALTER TABLE [dbo].[BangPhanCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK01_BangPhanCongCongNhan] FOREIGN KEY([maCN])
REFERENCES [dbo].[CongNhan] ([maCN])
GO
ALTER TABLE [dbo].[BangPhanCongCongNhan] CHECK CONSTRAINT [FK01_BangPhanCongCongNhan]
GO
ALTER TABLE [dbo].[BangPhanCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK02_BangPhanCongCongNhan] FOREIGN KEY([maCD])
REFERENCES [dbo].[CongDoan] ([maCD])
GO
ALTER TABLE [dbo].[BangPhanCongCongNhan] CHECK CONSTRAINT [FK02_BangPhanCongCongNhan]
GO
ALTER TABLE [dbo].[ChiTietHopDong]  WITH CHECK ADD  CONSTRAINT [FK01_ChiTietHopDong] FOREIGN KEY([maHD])
REFERENCES [dbo].[HopDong] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHopDong] CHECK CONSTRAINT [FK01_ChiTietHopDong]
GO
ALTER TABLE [dbo].[ChiTietHopDong]  WITH CHECK ADD  CONSTRAINT [FK02_ChiTiethopDong] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[ChiTietHopDong] CHECK CONSTRAINT [FK02_ChiTiethopDong]
GO
ALTER TABLE [dbo].[CongDoan]  WITH CHECK ADD  CONSTRAINT [FK01_CongDoan] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[CongDoan] CHECK CONSTRAINT [FK01_CongDoan]
GO
ALTER TABLE [dbo].[CongNhan]  WITH CHECK ADD  CONSTRAINT [FK01_CongNhan] FOREIGN KEY([maCV])
REFERENCES [dbo].[ChucVu] ([maCV])
GO
ALTER TABLE [dbo].[CongNhan] CHECK CONSTRAINT [FK01_CongNhan]
GO
ALTER TABLE [dbo].[CongNhan]  WITH CHECK ADD  CONSTRAINT [FK02_CongNhan] FOREIGN KEY([maTSX])
REFERENCES [dbo].[ToSanXuat] ([maTSX])
GO
ALTER TABLE [dbo].[CongNhan] CHECK CONSTRAINT [FK02_CongNhan]
GO
ALTER TABLE [dbo].[CongNhan]  WITH CHECK ADD  CONSTRAINT [FK03_CongNhan] FOREIGN KEY([maPhuCap])
REFERENCES [dbo].[PhuCap] ([maPhuCap])
GO
ALTER TABLE [dbo].[CongNhan] CHECK CONSTRAINT [FK03_CongNhan]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK01_NhanVien] FOREIGN KEY([maPB])
REFERENCES [dbo].[PhongBan] ([maPB])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK01_NhanVien]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK02_NhanVien] FOREIGN KEY([maCV])
REFERENCES [dbo].[ChucVu] ([maCV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK02_NhanVien]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK03_NhanVien] FOREIGN KEY([maPhuCap])
REFERENCES [dbo].[PhuCap] ([maPhuCap])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK03_NhanVien]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK01_TaiKhoan] FOREIGN KEY([maTK])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK01_TaiKhoan]
GO
USE [master]
GO
ALTER DATABASE [QLLSPAHG] SET  READ_WRITE 
GO
