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

SELECT PC.*
FROM [dbo].[CongNhan] AS CN
INNER JOIN [dbo].[BangPhanCongCongNhan] AS PC ON PC.maCN = CN.maCN
JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX
where  CN.trangThaiNV !=1 AND TSX.maTSX = 'TSX001' AND PC.maBPCCN LIKE '%301123'

Select * from [dbo].[ToSanXuat]

SELECT COUNT(CN.maCN) AS soLuongDaPhanCong
FROM [dbo].[CongNhan] AS CN
INNER JOIN [dbo].[BangPhanCongCongNhan] AS PC ON PC.maCN = CN.maCN
JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX
where  CN.trangThaiNV !=1 AND TSX.maTSX = 'TSX001' AND PC.maBPCCN LIKE '%301123'

Select COUNT(CN.maCN) 
from [dbo].[CongNhan] AS CN
JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX
where TSX.maTSX = 'TSX001'

SELECT CT.maSP, SP.tenSP
FROM [dbo].[ChiTietHopDong] AS CT
JOIN [dbo].[CongDoan] AS CD ON CD.maSP =CT.maSP
JOIN [dbo].[SanPham] AS SP ON SP.maSP= CT.maSP
WHERE CT.maHD='HD100000' AND CD.maCD='CDSP10001'

Select PC.*
from [dbo].[BangPhanCongCongNhan] AS PC
JOIN [dbo].[CongNhan] AS CN ON CN.maCN=PC.maCN
JOIN [dbo].[ToSanXuat] AS TSX ON TSX.maTSX = CN.maTSX
WHERE TSX.maTSX = 'TSX001' AND PC.maBPCCN LIKE '%031223'

SELECT CN.maCN, CN.hoCN, CN.tenCN
FROM [dbo].[CongNhan] AS CN
WHERE CN.maCN ='CN100000'

UPDATE [dbo].[BangPhanCongCongNhan] 
SET
[maBPCCN] ='PCCN100007031223',
[maCD] = 'CDSP10002',
[maHD] = 'HD10003',
[chiTieu] = 2500,
[ngayPhanCong] = '',
[ngayKetThuc] =''
WHERE [maBPCCN] LIKE '%'




--TamUngNhanVien

SELECT * FROM [dbo].[NhanVien]

SELECT * FROM [dbo].[TamUngNhanVien]
SELECT * FROM [dbo].[BangChamCongNhanVien]

INSERT [dbo].[TamUngNhanVien] ([maTUNV], [maNV], [ngayTamUng] )
VALUES
('TUNV100000121023', 'NV100000', '2023-12-10')

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
('CCNV100000081222','NV100000','2022-12-08', 0,1)

SELECT TU.maTUNV, TU.maNV, TU.ngayTamUng, TU.lyDo, TU.soTienTamUng, NV.hoNV, NV.tenNV, NV.luongCoBan,
SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) +
SUM(CASE WHEN BCC.diLam = 1 THEN 1 ELSE 0 END)  AS soNgayDiLam, PB.*
FROM [dbo].[TamUngNhanVien] AS TU
JOIN [dbo].[NhanVien] AS NV ON NV.maNV = TU.maNV 
JOIN [dbo].[BangChamCongNhanVien] AS BCC ON BCC.maNV = TU.maNV
JOIN [dbo].[PhongBan] AS PB ON PB.maPB = NV.maPB
WHERE MONTH (BCC.ngayChamCong) = 12 
AND YEAR (BCC.ngayChamCong) =2023 AND NV.trangThaiNV != 1
GROUP BY TU.maNV, TU.maTUNV, TU.ngayTamUng, TU.soTienTamUng
, TU.lyDo, NV.tenNV, NV.hoNV, NV.luongCoBan,PB.maPB, PB.tenPB


SELECT NV.hoNV, NV.tenNV, NV.luongCoBan,
SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) +  
SUM(CASE WHEN BCC.diLam = 1 THEN 1 ELSE 0 END)  AS SoNgayDiLam, PB.*	
FROM [dbo].[NhanVien] AS NV 
JOIN [dbo].[BangChamCongNhanVien] AS BCC ON BCC.maNV = NV.maNV
JOIN [dbo].[PhongBan] AS PB ON PB.maPB = NV.maPB
WHERE MONTH (BCC.ngayChamCong) = 12 
AND YEAR (BCC.ngayChamCong) = 2023 AND NV.trangThaiNV != 1
AND NV.maNV = 'NV100001'
GROUP BY  NV.tenNV, NV.hoNV, NV.luongCoBan,PB.maPB, PB.tenPB

SELECT SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) +  
SUM(CASE WHEN BCC.diLam = 1 THEN 1 ELSE 0 END)  AS SoNgayDiLam
FROM [dbo].[BangChamCongNhanVien] AS BCC
JOIN [dbo].[NhanVien] AS NV ON NV.maNV = BCC.maNV
WHERE MONTH (BCC.ngayChamCong) = 12 
AND YEAR (BCC.ngayChamCong) = 2023 AND NV.trangThaiNV != 1
AND NV.maNV = 'NV100001'

--Tam Ung CongNhan
SELECT * FROM [dbo].[CongNhan]
SELECT * FROM [dbo].[TamUngCongNhan]
SELECT * FROM [dbo].[BangChamCongCongNhan]
SELECT * FROM [dbo].[BangPhanCongCongNhan]

SELECT TU.maTUCN, TU.maCN, TU.ngayTamUng, TU.lyDo, TU.soTienTamUng, CN.hoCN, CN.tenCN,
SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) +
SUM(CASE WHEN BCC.soLuongLamDuoc > 0 THEN 1 ELSE 0 END)  AS soNgayDiLam,
TSX.*
FROM [dbo].[TamUngCongNhan] AS TU
JOIN [dbo].[CongNhan] AS CN ON CN.maCN = TU.maCN 
JOIN [dbo].[BangPhanCongCongNhan] AS BPC ON BPC.maCN = CN.maCN
JOIN [dbo].[BangChamCongCongNhan] AS BCC ON BCC.maBPCCN = BPC.maBPCCN
JOIN [dbo].[ToSanXuat] AS TSX ON TSX.maTSX = CN.maTSX
WHERE MONTH (BCC.ngayChamCong) = 12 
AND YEAR (BCC.ngayChamCong) =2023 
AND CN.trangThaiCN != 1
GROUP BY TU.maTUCN, TU.maCN, TU.maCN, TU.ngayTamUng, TU.soTienTamUng
, TU.lyDo, CN.tenCN, CN.hoCN,TSX.maTSX, TSX.tenTSX

SELECT CN.hoCN, CN.tenCN,
SUM(CASE WHEN BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END ) +  
SUM(CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END)  AS SoNgayDiLam, TSX.*	
FROM  [dbo].[CongNhan] AS CN
JOIN [dbo].[BangChamCongCongNhan] AS BCCCN ON BCCCN.maCN = CN.maCN
JOIN [dbo].[ToSanXuat] AS TSX ON TSX.maTSX = CN.maTSX
WHERE MONTH (BCCCN.ngayChamCong) = 12 
AND YEAR (BCCCN.ngayChamCong) = 2023 AND CN.trangThaiCN != 1
AND CN.maCN = 'CN100007'
GROUP BY  CN.tenCN, CN.hoCN,TSX.maTSX, TSX.tenTSX

--TimKiem nhanvien
SELECT * FROM [dbo].[PhongBan]
select * from [dbo].[BangChamCongNhanVien]

SELECT NV.email, NV.hoNV,NV.maNV,NV.sDT, NV.sTK, NV.tenNV, NV.trangThaiNV, PB.*,CV.maCV,CV.tenCV,
SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) AS SoNgayDiLam,
SUM(CASE WHEN BCC.diLam = 1 THEN 1 ELSE 0 END)  AS SoNgayNghiPhep,
SUM(CASE WHEN BCC.diLam =0 AND BCC.nghiPhep = 0 THEN 1 ELSE 0 END) AS soNgayNghi
FROM [dbo].[NhanVien] AS NV 
JOIN [dbo].[BangChamCongNhanVien] AS BCC ON BCC.maNV = NV.maNV
JOIN [dbo].[PhongBan] AS PB ON PB.maPB = NV.maPB
JOIN [dbo].[ChucVu] AS CV ON CV.maCV =NV.maCV
WHERE MONTH (BCC.ngayChamCong) = 12 
AND YEAR (BCC.ngayChamCong) = 2023
GROUP BY  NV.email, 
NV.hoNV,NV.maNV,NV.sDT, NV.sTK, NV.tenNV, NV.trangThaiNV, PB.maPB, PB.tenPB, CV.maCV,CV.tenCV

--Tim kiem cong nhan 
SELECT * FROM [dbo].[CongNhan]
SELECT * FROM [dbo].[BangPhanCongCongNhan]
SELECT * FROM [dbo].[BangChamCongCongNhan]
SELECT * FROM [dbo].[ToSanXuat]

SELECT CN.email, CN.hoCN,CN.maCN,CN.sDT, CN.sTK, CN.tenCN, CN.trangThaiCN, TSX.*,CV.maCV,CV.tenCV ,
SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) AS soNgayNghiPhep,
SUM(CASE WHEN BCC.soLuongLamDuoc > 0 THEN 1 ELSE 0 END)  AS soNgayDiLam,
SUM(CASE WHEN BCC.nghiPhep = 1 AND BCC.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) AS soNgayNghi,
SUM(BPC.[chiTieu]) AS soLuongDuocPhanCong,
SUM(BCC.[soLuongLamDuoc]) AS soLuongLamDuoc
FROM [dbo].[CongNhan] AS CN  
JOIN [dbo].[BangPhanCongCongNhan] AS BPC ON BPC.maCN = CN.maCN
JOIN [dbo].[BangChamCongCongNhan] AS BCC ON BCC.maBPCCN = BPC.maBPCCN
JOIN [dbo].[ChucVu] AS CV ON CV.[maCV] = CN.[maCV]
JOIN [dbo].[ToSanXuat] AS TSX ON TSX.maTSX = CN.maTSX
WHERE MONTH (BCC.ngayChamCong) = 12 
AND YEAR (BCC.ngayChamCong) =2023 
GROUP BY CN.email, CN.hoCN,CN.maCN,CN.sDT, CN.sTK, CN.tenCN, CN.trangThaiCN,
TSX.maTSX, TSX.tenTSX,CV.maCV,CV.tenCV 

