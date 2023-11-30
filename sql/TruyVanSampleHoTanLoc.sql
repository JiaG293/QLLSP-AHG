Select * 
From ChucVu
where ChucVu.loaiCV = 'NV'

Select *
From NhanVien
where NhanVien.gioiTinh = 1

Select nv.*, cv.*, pb.*,pc.maPhuCap
From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc
where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh = 1

Select nv.*, cv.*, pb.*,pc.maPhuCap
From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc
Where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and cv.tenCV = 'Nhan Vien Ke Toan'

Select nv.*, cv.*, pb.*,pc.maPhuCap
From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc
where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and pb.tenPB = 'Phong Quan Li'

Select nv.*, cv.*, pb.*,pc.maPhuCap
From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc
where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh = 1  and cv.tenCV ='Nhan Vien Ke Toan'

Select nv.*, cv.*, pb.*,pc.maPhuCap
From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc
where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh = 1  and pb.tenPB ='Phong Quan Li'

Select nv.*, cv.*, pb.*,pc.maPhuCap
From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc
where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh = 1 and cv.tenCV ='Nhan Vien Ke Toan' and pb.tenPB ='Phong Quan Li'

Select nv.*, cv.*, pb.*,pc.maPhuCap
From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc
where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and cv.tenCV ='Nhan Vien Ke Toan' and pb.tenPB ='Phong Quan Li'

Select *
From [dbo].[NhanVien]
Order by [maNV] ASC

Select*
from [dbo].[PhuCap]

Select nv.*, cv.*, pb.*,pc.maPhuCap
From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc
where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap AND nv.tonTai !=0

update [dbo].[NhanVien] 
set tonTai = 1 
where [dbo].[NhanVien].maNV= 'NV0007'

use [QLLSPAHG]
select * from  [dbo].[SanPham]

SELECT [dbo].[ToSanXuat].*,COUNT([dbo].[CongNhan].maCN ) AS 'Soluong'FROM [dbo].[CongNhan] 
LEFT JOIN [dbo].[ToSanXuat] ON [dbo].[ToSanXuat].maTSX= [dbo].[CongNhan].maTSX
where [dbo].[CongNhan].trangThaiNV !=1 
GROUP BY [dbo].[ToSanXuat].maTSX, [dbo].[ToSanXuat].tenTSX;

select cn.maCN, cn.hoCN,cn.tenCN
from [dbo].[CongNhan] as cn
where maTSX='TSX001'

select cd.*, sp.tenSP
from [dbo].[CongDoan] as cd, [dbo].[SanPham] as sp
where cd.maSP = 'SP1000' and sp.maSP = cd.maSP

select * from [dbo].[BangPhanCongCongNhan]

Select [dbo].[ChiTietHopDong].maHD, [dbo].[SanPham].maSP, [dbo].[SanPham].tenSP, [dbo].[ChiTietHopDong].soLuongDat
                from [dbo].[ChiTietHopDong] 
                Inner Join [dbo].[SanPham] on [dbo].[ChiTietHopDong].maSP = [dbo].[SanPham].maSP
                where [dbo].[ChiTietHopDong].maHD = 'HD100000'

--Phan cong cong nhan
SELECT [dbo].[HopDong].*
FROM [dbo].[HopDong]
WHERE [dbo].[HopDong].trangThaiHD !=1

SELECT  TSX.tenTSX
FROM [dbo].[ToSanXuat] as TSX

SELECT DISTINCT CT.maSP, SP.tenSP, CT.soLuongDat - SUM(CT.soLuongDaLam)  as soLuongCanLam
FROM [dbo].[ChiTietHopDong] AS CT
INNER JOIN [dbo].[HopDong] AS HD ON HD.maHD = CT.maHD
INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CT.maSP
WHERE HD.trangThaiHD !=1 and CT.maHD= 'HD100033'
GROUP BY CT.maHD, CT.soLuongDaLam, CT.maSP, CT.soLuongDat,SP.tenSP;

SELECT DISTINCT SP.tenSP
FROM [dbo].[ChiTietHopDong] AS CT
INNER JOIN [dbo].[HopDong] AS HD ON HD.maHD = CT.maHD
INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CT.maSP
WHERE HD.trangThaiHD !=1 AND CT.maHD = 'HD100033'

SELECT CT.soLuongDat - SUM(CT.soLuongDaLam)  as soLuongCanLam
FROM [dbo].[ChiTietHopDong] AS CT
INNER JOIN [dbo].[HopDong] AS HD ON CT.maHD = HD.maHD
INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CT.maSP
WHERE HD.trangThaiHD !=1 AND CT.maHD ='HD100037' AND SP.tenSP = N'Ba lô 50'
GROUP BY CT.soLuongDaLam, CT.soLuongDat

select CT.* 
from [dbo].[ChiTietHopDong] as CT
INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CT.maSP
where CT.maHD ='HD100037' AND SP.tenSP = N'Ba lô 50'

SELECT CD.tenCD
FROM [dbo].[CongDoan] AS CD
INNER JOIN [dbo].[SanPham] AS SP ON CD.maSP = SP.maSP
where SP.tenSP=N'Ba lô 1'

SELECT CD.maCD
FROM [dbo].[SanPham] as SP
INNER JOIN [dbo].[CongDoan] AS CD on SP.maSP = CD.maSP 
WHERE SP.tenSP=N'Ba lô 1' and CD.tenCD = N'Cắt'

SELECT CT.soLuongDat - SUM(CT.soLuongDaLam)  as soLuongCanLam
FROM [dbo].[ChiTietHopDong] AS CT
INNER JOIN [dbo].[HopDong] AS HD ON CT.maHD = HD.maHD
INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CT.maSP
WHERE HD.trangThaiHD !=1 AND CT.maHD ='HD100033' AND SP.tenSP = N'Ba lô 1'
GROUP BY CT.soLuongDaLam, CT.soLuongDat

SELECT CT.soLuongDat - SUM(CT.soLuongDaLam)  as soLuongCanPhanCong
FROM [dbo].[ChiTietHopDong] AS CT
INNER JOIN [dbo].[HopDong] AS HD ON CT.maHD = HD.maHD
INNER JOIN [dbo].[BangPhanCongCongNhan] AS PC ON PC.maHD = CT.maHD
INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CT.maSP
INNER JOIN [dbo].[CongDoan] AS CD ON SP.maSP = CD.maSP
where CT.maHD='HD100033' AND SP.tenSP= N'Ba lô 1' AND CD.tenCD = N'Cắt' 
GROUP BY CT.soLuongDaLam,CT.soLuongDat,PC.chiTieu

SELECT SUM(PC.chiTieu) As soLuongCanLam
FROM [dbo].[BangPhanCongCongNhan] AS PC 
WHERE  PC.maHD='HD100033' AND PC.maCD= 'CDSP10001'

SELECT DISTINCT CD.tenCD
FROM [dbo].[CongDoan] AS CD
INNER JOIN [dbo].[SanPham] AS SP ON CD.maSP = SP.maSP
INNER JOIN [dbo].[ChiTietHopDong] AS CT ON SP.maSP = CT.maSP
where SP.tenSP=N'Ba lô 1' AND CT.maHD='HD100033'

SELECT *
FROM [dbo].[CongNhan]

SELECT *
FROM [dbo].[ToSanXuat]

SELECT *
FROM [dbo].[BangPhanCongCongNhan]

SELECT  TSX.maTSX, TSX.tenTSX
FROM  [dbo].[ToSanXuat] AS TSX
JOIN [dbo].[CongNhan] AS CN ON CN.maTSX = TSX.maTSX, [dbo].[BangPhanCongCongNhan] AS PC 



SELECT COUNT(CN.maCN) AS SoLuongNguoiTrongTo
FROM [dbo].[CongNhan] AS CN
JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX
where  CN.trangThaiNV !=1 AND TSX.maTSX = 'TSX001'

SELECT CN.maCN
FROM [dbo].[CongNhan] AS CN
INNER JOIN [dbo].[BangPhanCongCongNhan] AS PC ON PC.maCN = CN.maCN
JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX
where  CN.trangThaiNV !=1 AND TSX.maTSX = 'TSX001' AND PC.maBPCCN LIKE '%301123'

SELECT DISTINCT CN.maCN, CN.tenCN
FROM [dbo].[CongNhan] AS CN
where  CN.trangThaiNV !=1 AND CN.maTSX = 'TSX001' AND CN.maCN !='CN100000' AND CN.maCN!='CN100001'

SELECT CN.maCN
FROM [dbo].[CongNhan] AS CN
INNER JOIN [dbo].[BangPhanCongCongNhan] AS PC ON PC.maCN = CN.maCN
JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX
where  CN.trangThaiNV !=1 AND TSX.maTSX = 'TSX001' AND PC.maBPCCN LIKE '%291123'

INSERT [dbo].[BangPhanCongCongNhan] ([maBPCCN], [maCN], [maCD], [maHD], [chiTieu], [ngayPhanCong], [ngayKetThuc] )
VALUES 
(?,?,?,?,?,?,?)

SELECT * FROM [dbo].[BangPhanCongCongNhan]

