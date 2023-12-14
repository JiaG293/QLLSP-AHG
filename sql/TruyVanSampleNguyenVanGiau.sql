INSERT INTO BangChamCongNhanVien (maBCCNV, maNV, ngayChamCong)
VALUES ('NV100000231108','NV100000','2023-11-09');

SELECT NV.maNV, NV.hoNV, NV.tenNV, PB.*
FROM NhanVien as NV, PhongBan as PB
WHERE NV.maNV = NV.maNV AND PB.maPB =PB.maPB

Select bcnv.*, nv.[maNV], nv.[hoNV] + nv.[tenNV] as hoTenNV ,pb.tenPB
from [dbo].[BangChamCongNhanVien] as bcnv, [dbo].[NhanVien] as nv,  PhongBan as PB
where bcnv.maNV =nv.maNV and nv.maPB = pb.maPB


--SanPham

SELECT TOP (1000) [maCD]
      ,[maSP]
      ,[tenCD]
      ,[giaiDoan]
      ,[giaCongDoan]
  FROM [QLLSPAHG].[dbo].[CongDoan]

SELECT CD.*, SP.* --maCD
FROM [dbo].[SanPham] as SP
INNER JOIN [dbo].[CongDoan] AS CD on SP.maSP = CD.maSP 
WHERE SP.tenSP=N'Ba lô 1' and CD.tenCD = N'Cắt'

SELECT SUM(PC.chiTieu) As soLuongCanLam
FROM [dbo].[BangPhanCongCongNhan] AS PC 
WHERE  PC.maHD='HD100033' AND PC.maCD= 'CDSP10001'

SELECT SUM(CD.giaCongDoan) AS giaTienSPMoi
FROM CongDoan AS CD
WHERE CD.maSP = 'SP1001'

SELECT SUM(CD.giaCongDoan) AS giaSPMoi
FROM CongDoan AS CD
WHERE CD.maSP = 'SP1001';

UPDATE SanPham
SET giaSP = 1500
WHERE maSP = 'SP1001';

UPDATE SanPham
SET giaSP = (
    SELECT SUM(CD.giaCongDoan) AS giaSPMoi
    FROM CongDoan AS CD
    WHERE CD.maSP = 'SP1000'
)
WHERE maSP = 'SP1000';

SELECT 
    (SELECT giaSP FROM SanPham WHERE maSP = 'SP1000') AS giaSPCu,
    (SELECT SUM(CD.giaCongDoan) FROM CongDoan AS CD WHERE CD.maSP = 'SP1000') AS giaSPMoi;

SELECT 
    (SELECT giaSP FROM SanPham WHERE maSP = 'SP1001') AS giaSPCu,
    (SELECT SUM(CD.giaCongDoan) FROM CongDoan AS CD WHERE CD.maSP = 'SP1001') AS giaSPMoi,
    CASE 
        WHEN (SELECT giaSP FROM SanPham WHERE maSP = 'SP1001') <> (SELECT SUM(CD.giaCongDoan) FROM CongDoan AS CD WHERE CD.maSP = 'SP1001') THEN 'true'
        ELSE 'false'
    END AS isGiaThayDoi;

UPDATE SanPham
SET giaSP = (SELECT SUM(CD.giaCongDoan) FROM CongDoan AS CD WHERE CD.maSP = 'SP1001')
WHERE maSP = 'SP1001'
    AND (
        SELECT giaSP FROM SanPham WHERE maSP = 'SP1001'
    ) <> (
        SELECT SUM(CD.giaCongDoan) FROM CongDoan AS CD WHERE CD.maSP = 'SP1001'
    );


SELECT DISTINCT tenLoai
FROM SanPham
WHERE tenLoai IS NOT NULL;

SELECT SP.*
FROM SanPham AS SP
WHERE SP.tenLoai = N'Ba lô du lịch' 


--HopDOng
SELECT HD.*
FROM HopDong AS HD

SELECT CTHD.*
FROM ChiTietHopDong AS CTHD
--BangPhanCongCongNhan (maBPCCN, maCN, maCD, maHD, chiTieu, ngayPhanCong, ngayKetThuc)
--BangChamCongCongNhan(maBCCCN, maBPCCN, ngayChamCong, soLuongLamDuoc, soLuongLamCa3, nghiPhep) 
--ToSanXuat(maTSX, tenTSX)
--CongNhan(maCN, maCV, maTSX, maPhuCap, hoCN, tenCN, gioiTinh, ngaySinh, sDT, email, ngayVaoLam, sTK, trangThaiCN)

--BangPhanCongCongNhan 
SELECT BPCCN.*
FROM BangPhanCongCongNhan AS BPCCN
INSERT INTO BangPhanCongCongNhan (maBPCCN, maCN, maCD, maHD, chiTieu, ngayPhanCong, ngayKetThuc)
	VALUES 
		('PCCN100004011223', 'CN100004', 'CDSP10012', 'HD100034', 30, '2023-12-01', '2023-12-01'),
		('PCCN100007011223', 'CN100007', 'CDSP10001', 'HD100033', 30, '2023-12-01', '2023-12-01'),
		('PCCN100012011223', 'CN100012', 'CDSP10001', 'HD100033', 30, '2023-12-01', '2023-12-01'),
		('PCCN100013011223', 'CN100013', 'CDSP10012', 'HD100034', 30, '2023-12-01', '2023-12-01'),
		('PCCN100019011223', 'CN100019', 'CDSP10012', 'HD100034', 30, '2023-12-01', '2023-12-01'),
		('PCCN100027011223', 'CN100027', 'CDSP10001', 'HD100033', 30, '2023-12-01', '2023-12-01');

SELECT BPCCN.*, CN.*
FROM BangPhanCongCongNhan AS BPCCN
INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN

--ChamCongCongNhan
SELECT BCCN.*
FROM BangChamCongCongNhan AS BCCN

INSERT INTO BangChamCongCongNhan (maBCCCN, maBPCCN, ngayChamCong) 
	VALUES 
		( 'CCCN100004011223', 'PCCN100004011223', '2023-12-01');


SELECT BCCCN.*, BPCCN.*, TSX.*, CN.*
FROM BangChamCongCongNhan AS BCCCN
INNER JOIN BangPhanCongCongNhan AS BPCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN
INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN
INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX

SELECT BPCCN.*, TSX.*, CN.*
FROM BangPhanCongCongNhan AS BPCCN
INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN
INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX
WHERE BPCCN.ngayPhanCong = '2023-12-01'

SELECT TSX.* FROM ToSanXuat AS TSX

SELECT BPCCN.*, TSX.*
FROM BangPhanCongCongNhan AS BPCCN
INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN
INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX
WHERE BPCCN.ngayPhanCong = '2023-12-01'

SELECT DISTINCT TSX.*
FROM BangPhanCongCongNhan AS BPCCN
INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN
INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX
WHERE BPCCN.ngayPhanCong = '2023-12-01'

UPDATE BangChamCongCongNhan SET soLuongLamDuoc = ?, soLuongLamCa3 = ?, nghiPhep = ? WHERE maBCCCN = ? AND ngayChamCong = ?


SELECT BCCN.*
FROM BangChamCongCongNhan AS BCCN

UPDATE BangChamCongCongNhan SET soLuongLamDuoc = 0, soLuongLamCa3 = 0, nghiPhep = 0 WHERE maBCCCN = 'CCCN100004011223'-- AND ngayChamCong = '2023-12-01'

SELECT BCCCN.*, BPCCN.*, TSX.*, CN.*
FROM BangChamCongCongNhan AS BCCCN
INNER JOIN BangPhanCongCongNhan AS BPCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN
INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN
INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX
WHERE BCCCN.ngayChamCong = '2023-12-01'

SELECT BCCCN.*, BPCCN.*, TSX.*, CN.*
FROM BangChamCongCongNhan AS BCCCN
INNER JOIN BangPhanCongCongNhan AS BPCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN
INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN
INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX
WHERE CN.trangThaiCN = 0 AND BPCCN.maCN = 'CN100004' AND  CN.tenCN LIKE '%Ra%' AND TSX.tenTSX = N'Tổ 2' AND BCCCN.ngayChamCong = '2023-12-01'



--TinhLUong nhan vien



--BangChamCongNhanVien(maBCCNV, maNV, ngayChamCong, diLam, nghiPhep, tangCa)
--PhuCap(maPhuCap, tienChuyenCan, tienNangSuat, tienConNho, tienDiLai, tienNhaTro, tienDienThoai)
--TamUngNhanVien(maTUNV, ngayTamUng, lyDo, soTienTamUng);
--ChucVu(maCV, tenCV, heSoCV)
--PhongBan(maPB, tenPB)
--NhanVien(maNV, maPB, maCV, maPhuCap, hoNV, tenNV, gioiTinh, ngaySinh, sDT, email, ngayVaoLam, sTK, luongCoBan, trangThaiNV)

--- Tôi muốn join tất cả các bảng này lại 
--- Lọc theo tháng năm ở bảng BangChamCongNhanVien
--- Và tạo ra cột soNgayDiLam = tổng số ngày đi làm nơi có mã bảng chấm công nhân viên phù hợp
--- Và tạo ra cột soNgayNghi = 
--- Và tạo ra cột soNgayCoPhep = 
--- Và tạo ra cột soNgayTangCa = 
--- Và tạo ra cột luongNhanDuoc  = ((luongCoBan/26) * soNgayDiLam) * heSoCV
--- Và tạo ra cột phiBHYT =  luongNhanDuoc * 1.5%
--- Và tạo ra cột phiBHXH = luongNhanDuoc * 8.5%
--- Và tạo ra cột luongThucTe = luongNhanDuoc + (((luongCoBan/26)*soNgayTangCa)  * heSoCV) + (tienChuyenCan + tienConNho + tienNhaTro) [nếu có mã phụ cấp ở giống ở NhanVien] - phiBHYT - phiBHXH - tamUng (nếu trùng mã tạm ứng)

SELECT 
    NV.maNV,
    NV.hoNV,
    NV.tenNV,
    NV.luongCoBan,
    CV.heSoCV,
    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,
    SUM(CASE WHEN BCCNV.nghiPhep = 'True' OR BCCNV.nghiPhep = 1 THEN 1 ELSE 0 END) AS soNgayNghi,
    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,
    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,
		((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) +
		((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV) +
        COALESCE(SUM(PC.tienChuyenCan), 0) + COALESCE(SUM(PC.tienConNho), 0) + COALESCE(SUM(PC.tienNhaTro), 0) - 
        ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END * CV.heSoCV) * 1.5 / 100) - 
        -((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END * CV.heSoCV) * 8.5 / 100) - 
        COALESCE(SUM(TUNV.soTienTamUng), 0) 
		AS luongThucTe
FROM 
    BangChamCongNhanVien AS BCCNV
JOIN 
    NhanVien NV ON BCCNV.maNV = NV.maNV
LEFT JOIN 
    ChucVu CV ON NV.maCV = CV.maCV
LEFT JOIN 
    PhuCap PC ON NV.maPhuCap = PC.maPhuCap
LEFT JOIN 
    TamUngNhanVien TUNV ON NV.maNV = TUNV.maTUNV
WHERE 
    YEAR(BCCNV.ngayChamCong) = 2023 
    AND MONTH(BCCNV.ngayChamCong) = 12
GROUP BY 
    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV;





	--Tinh oke luong thuc te 6.322.412  + 30k phu cap = 6.362.412
SELECT 
    NV.maNV,
    NV.hoNV,
    NV.tenNV,
    NV.luongCoBan,
    CV.heSoCV,
    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,
    SUM(CASE WHEN BCCNV.nghiPhep = 'True' OR BCCNV.nghiPhep = 1 THEN 1 ELSE 0 END) AS soNgayNghi,
    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,
    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,
		((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) +
		((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV) +
		(((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) * CV.heSoCV)) +
        (
			CASE WHEN NV.maPhuCap = PC.maPhuCap THEN
            COALESCE(PC.tienChuyenCan, 0) + COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)
			ELSE
				0
			END
		) -
        ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END * CV.heSoCV) * 1.5 / 100) - 
        -((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END * CV.heSoCV) * 8.5 / 100) - 
        COALESCE(SUM(TUNV.soTienTamUng), 0) 
        AS luongThucTe
FROM 
    BangChamCongNhanVien AS BCCNV
JOIN 
    NhanVien NV ON BCCNV.maNV = NV.maNV
LEFT JOIN 
    ChucVu CV ON NV.maCV = CV.maCV
LEFT JOIN 
    PhuCap PC ON NV.maPhuCap = PC.maPhuCap
LEFT JOIN 
    TamUngNhanVien TUNV ON NV.maNV = TUNV.maTUNV
WHERE 
    YEAR(BCCNV.ngayChamCong) = 2023 
    AND MONTH(BCCNV.ngayChamCong) = 12
GROUP BY 
    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, NV.maPhuCap, PC.maPhuCap, PC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro;












SELECT 
    NV.maNV,
    NV.hoNV,
    NV.tenNV,
    NV.luongCoBan,
    CV.heSoCV,
    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,
    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) AS soNgayNghi,
    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,
    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,
(
        ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) +
        ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV) +
    (
            CASE WHEN NV.maPhuCap = PC.maPhuCap THEN
                COALESCE(PC.tienChuyenCan, 0) + COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)
            ELSE
                0
            END
	) -
	((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END * CV.heSoCV) * 1.5 / 100) - 
	((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END * CV.heSoCV) * 8.5 / 100) - 
	(
            CASE WHEN NV.maNV = TUNV.maTUNV THEN
                COALESCE(TUNV.soTienTamUng, 0)
            ELSE
                0
            END
	) -
	(
			CASE WHEN (SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)) > -1 
				THEN 
					(SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)) * 50000 
			ELSE 0 
			END
	)
) AS luongThucTe	
FROM BangChamCongNhanVien AS BCCNV
JOIN NhanVien NV ON BCCNV.maNV = NV.maNV
LEFT JOIN ChucVu CV ON NV.maCV = CV.maCV
LEFT JOIN PhuCap PC ON NV.maPhuCap = PC.maPhuCap
LEFT JOIN TamUngNhanVien TUNV ON NV.maNV = TUNV.maTUNV
WHERE 
    YEAR(BCCNV.ngayChamCong) = 2023 AND MONTH(BCCNV.ngayChamCong) = 12
GROUP BY 
    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, NV.maPhuCap, PC.maPhuCap, PC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro, TUNV.maTUNV, TUNV.soTienTamUng;



	(3815135 /26 * 30 * 1.1) +
	(3815135 /26 * 2 * 1.1) + 30000 -
	(3815135 /26 * 30 * 1.1 * 1.5 / 100) -
	(3815135 /26 * 30 * 1.1 * 8.5 / 100) - 
	50000



	4842287 - 72634,3 - 411594,4 - 50000

--Test
SELECT 
    NV.*,
    CV.heSoCV,
    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) OVER (PARTITION BY NV.maNV) AS soNgayDiLam,
    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) OVER (PARTITION BY NV.maNV) AS soNgayNghi,
    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) OVER (PARTITION BY NV.maNV) AS soNgayCoPhep,
    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) OVER (PARTITION BY NV.maNV) AS soNgayTangCa,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) OVER (PARTITION BY NV.maNV) * CV.heSoCV) AS luongNhanDuoc,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) OVER (PARTITION BY NV.maNV) * CV.heSoCV * 1.5 / 100) AS phiBHYT,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) OVER (PARTITION BY NV.maNV) * CV.heSoCV * 8.5 / 100) AS phiBHXH,
    (
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) OVER (PARTITION BY NV.maNV) * CV.heSoCV
        ) +
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) OVER (PARTITION BY NV.maNV) * CV.heSoCV
        ) +
        (
            CASE WHEN NV.maPhuCap = PC.maPhuCap THEN COALESCE(PC.tienChuyenCan, 0) + COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)
            ELSE 0
            END
        ) -
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END * CV.heSoCV) * 1.5 / 100
        ) - 
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END * CV.heSoCV) * 8.5 / 100
        ) - 
        (
            CASE WHEN NV.maNV = TUNV.maTUNV THEN COALESCE(TUNV.soTienTamUng, 0)
            ELSE 0
            END
        ) -
        (
            CASE WHEN (SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)) > -1 
                THEN (SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)) * 50000 
                ELSE 0 
            END
        )
    ) AS luongThucTe	
FROM 
    BangChamCongNhanVien AS BCCNV
JOIN 
    NhanVien NV ON BCCNV.maNV = NV.maNV
LEFT JOIN 
    ChucVu CV ON NV.maCV = CV.maCV
LEFT JOIN 
    PhuCap PC ON NV.maPhuCap = PC.maPhuCap
LEFT JOIN 
    TamUngNhanVien TUNV ON NV.maNV = TUNV.maTUNV
WHERE 
    YEAR(BCCNV.ngayChamCong) = 2023 AND MONTH(BCCNV.ngayChamCong) = 12;





-- các cột khác ở đây finish tinh luong nhan vien chua co tam ung 

SELECT 
    NV.maNV,
    NV.hoNV,
    NV.tenNV,
    NV.luongCoBan,
    CV.heSoCV,
    PB.tenPB,
    TUNV.soTienTamUng,
    PC.tienChuyenCan,
    PC.tienConNho,
    PC.tienNhaTro,
    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,
    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) AS soNgayNghi,
    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,
    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,
    (
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV
        ) +
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV
        ) +
        (
            COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)

        ) -
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100
        ) - 
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100
        ) - 
        (
             COALESCE(TUNV.soTienTamUng, 0)
        ) -
        (
            CASE WHEN (
                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - 
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)
            ) > -1 
            THEN (
                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - 
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)
            ) * 50000
            ELSE 0 
            END
        ) +
        (
            CASE WHEN
				SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) = 0 
            THEN PC.tienChuyenCan
            ELSE 0 
            END
        )
		
    ) AS luongThucTe
    
FROM 
    BangChamCongNhanVien AS BCCNV
JOIN 
    NhanVien AS NV ON BCCNV.maNV = NV.maNV
LEFT JOIN
    PhongBan AS PB ON PB.maPB = NV.maPB
LEFT JOIN 
    ChucVu AS CV ON NV.maCV = CV.maCV
LEFT JOIN 
    PhuCap AS PC ON NV.maPhuCap = PC.maPhuCap
LEFT JOIN 
    TamUngNhanVien AS TUNV ON NV.maNV = TUNV.maTUNV
WHERE 
    MONTH(BCCNV.ngayChamCong) = 12 AND YEAR(BCCNV.ngayChamCong) = 2023 
GROUP BY 
    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, PB.tenPB, TUNV.soTienTamUng, PC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro, NV.maPhuCap;


	Select TUNV.*
	FROM TamUngNhanVien as TUNV



--tinh luong nhan vien them tam ung 

SELECT 
    NV.maNV,
    NV.hoNV,
    NV.tenNV,
    NV.luongCoBan,
    CV.heSoCV,
    PB.tenPB,
    TUNV.soTienTamUng,
	TUNV.ngayTamUng,
    PC.tienChuyenCan,
    PC.tienConNho,
    PC.tienNhaTro,
    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,
    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) AS soNgayNghi,
    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,
    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,
    (
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV
        ) +
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV
        ) +
        (
            COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)

        ) -
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100
        ) - 
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100
        ) - 
        (
              CASE WHEN (
                MONTH(TUNV.ngayTamUng) = 12 AND YEAR(TUNV.ngayTamUng) = 2023
            )
            THEN TUNV.soTienTamUng
            ELSE 0 
            END
        ) -
        (
            CASE WHEN (
                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - 
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)
            ) > -1 
            THEN (
                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - 
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)
            ) * 50000
            ELSE 0 
            END
        ) +
        (
            CASE WHEN
				SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) = 0 
            THEN PC.tienChuyenCan
            ELSE 0 
            END
        )
		
    ) AS luongThucTe
    
FROM 
    BangChamCongNhanVien AS BCCNV
JOIN 
    NhanVien AS NV ON BCCNV.maNV = NV.maNV
LEFT JOIN
    PhongBan AS PB ON PB.maPB = NV.maPB
LEFT JOIN 
    ChucVu AS CV ON NV.maCV = CV.maCV
LEFT JOIN 
    PhuCap AS PC ON NV.maPhuCap = PC.maPhuCap
LEFT JOIN 
    TamUngNhanVien AS TUNV ON NV.maNV = TUNV.maNV
WHERE 
    MONTH(BCCNV.ngayChamCong) = 12 AND YEAR(BCCNV.ngayChamCong) = 2023 
GROUP BY 
    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, PB.tenPB, TUNV.soTienTamUng, TUNV.ngayTamUng, PC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro, NV.maPhuCap;

--TRuy van tinh luong co tam ung 
SELECT 
    NV.maNV,
    NV.hoNV,
    NV.tenNV,
    NV.luongCoBan,
	TUNV.soTienTamUng,
	TUNV.ngayTamUng,
    CV.heSoCV,
    PB.tenPB,
    PC.tienConNho,
    PC.tienNhaTro,
	(
		CASE WHEN ( SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) -
			SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) )
			> -1 THEN PC.tienChuyenCan
			ELSE 0 END
	) AS tienChuyenCan,
    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,
    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) AS soNgayNghi,
    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,
    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,

	

	
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,
    (
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV
        ) +
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV
        ) +
        (
            COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)
        ) -
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100
        ) - 
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100
        ) - 
        (
             COALESCE(TUNV.soTienTamUng, 0)
        ) -
        (
            CASE WHEN (
                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - 
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)
            ) > -1 
            THEN (
                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - 
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)
            ) * 50000
            ELSE 0 
            END
        ) +
        (
            CASE WHEN
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) = 0 
            THEN PC.tienChuyenCan
            ELSE 0 
            END
        )
    ) AS luongThucTe
FROM 
	NhanVien AS NV
LEFT JOIN 
    BangChamCongNhanVien AS BCCNV ON NV.maNV = BCCNV.maNV --AND MONTH(BCCNV.ngayChamCong) = 12 AND YEAR(BCCNV.ngayChamCong) = 2023 
LEFT JOIN
    PhongBan AS PB ON PB.maPB = NV.maPB
LEFT JOIN 
    ChucVu AS CV ON NV.maCV = CV.maCV
LEFT JOIN 
    PhuCap AS PC ON NV.maPhuCap = PC.maPhuCap
LEFT JOIN 
    TamUngNhanVien AS TUNV ON NV.maNV = TUNV.maNV --AND MONTH(TUNV.ngayTamUng) = 12 AND YEAR(TUNV.ngayTamUng) = 2023 
GROUP BY 
    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, PB.tenPB,TUNV.soTienTamUng, TUNV.ngayTamUng,
	PC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro, NV.maPhuCap;





--TInh luong cong nhan


--BangPhanCongCongNhan(maBPCCN, maCN, maCD, maHD, chiTieu, ngayPhanCong, ngayKetThuc, trangThaiTangCa)
--BangChamCongCongNhan(maBCCCN, maBPCCN, ngayChamCong, soLuongLamDuoc, soLuongLamCa3, nghiPhep)
--PhuCap(maPhuCap, tienNangSuat, tienConNho,tienNhaTro)
--TamUngCongNhan(maTUCN, maCN, ngayTamUng, lyDo, soTienTamUng, trangThaiTUCN);
--ChucVu(maCV, tenCV, heSoCV)
--ToSanXuat(maTSX, tenTSX)
--NhanVien(maCN, maTSX, maCV, maPhuCap, hoCN, tenCN, gioiTinh, ngaySinh, sDT, email, ngayVaoLam, sTK, trangThaiCN)
--HopDong(maHD, tenKH, sDT,diaChi, email, ngayKKHD, ngayTLHD, trangThaiHD)
--ChiTietHopDong(maHD, maSP, soLuongDat, soLuongDaLam)
--SanPham(maSP, tenLoai, tenSP, giaSP, trangThaiSP)
--CongDoan(maCD, maSP, tenCD, giaiDoan, giaCongDoan)


SELECT 
    fsdfsdf
FROM 
	CongNhan AS CN
LEFT JOIN 
    BangPhanCongCongNhan AS BPCCN ON CN.maCN = BPCCN.maCN AND MONTH(BPCCN.ngayPhanCong) = 12 AND YEAR(BPCCN.ngayPhanCong) = 2023 
LEFT JOIN 
    BangChamCongCongNhan AS BCCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN 
LEFT JOIN
    ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX
LEFT JOIN 
    ChucVu AS CV ON CN.maCV = CV.maCV
LEFT JOIN 
    PhuCap AS PC ON CN.maPhuCap = PC.maPhuCap
LEFT JOIN 
    TamUngCongNhan AS TUCN ON CN.maCN = TUCN.maCN AND MONTH(TUCN.ngayTamUng) = 12 AND YEAR(TUCN.ngayTamUng) = 2023 




	-- COng thuc lay ra so luong san pham lam duoc cua moi phan cong cua moi cong doan
SELECT
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	HD.maHD,
	SP.maSP,
	BPCCN.maBPCCN, BPCCN.chiTieu,
	BCCCN.maBCCCN,
	CD.maCD, CD.giaCongDoan,
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END ) AS diLam,
    SUM( BCCCN.soLuongLamDuoc ) AS soLuongLamDuoc,
	SUM( CASE WHEN ( BPCCN.chiTieu <= BCCCN.soLuongLamDuoc ) THEN 1 ELSE 0 END ) AS nangSuat,
	SUM( CASE WHEN ( BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 ) THEN 1 ELSE 0 END) AS phanTangCaCoDiLam,
	SUM( BCCCN.soLuongLamCa3) AS soLuongLamCa3,
	SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) AS tienCongCongDoan
FROM CongNhan AS CN
	LEFT JOIN BangPhanCongCongNhan BPCCN ON CN.maCN = BPCCN.maCN AND MONTH(BPCCN.ngayKetThuc) = 12 AND YEAR(BPCCN.ngayKetThuc) = 2023 
	LEFT JOIN BangChamCongCongNhan BCCCN ON BPCCN.maBPCCN = BCCCN.maBPCCN AND MONTH(BCCCN.ngayChamCong) = 12 AND YEAR(BCCCN.ngayChamCong) = 2023 
	LEFT JOIN PhuCap PC ON CN.maPhuCap = PC.maPhuCap
	LEFT JOIN TamUngCongNhan TUCN ON CN.maCN = TUCN.maCN AND MONTH(TUCN.ngayTamUng) = 10 AND YEAR(TUCN.ngayTamUng) = 2023 
	LEFT JOIN ChucVu CV ON CN.maCV = CV.maCV
	LEFT JOIN ToSanXuat TSX ON CN.maTSX = TSX.maTSX
	LEFT JOIN HopDong HD ON BPCCN.maHD = HD.maHD
	LEFT JOIN ChiTietHopDong CTHD ON BPCCN.maHD = CTHD.maHD
	LEFT JOIN SanPham SP ON CTHD.maSP = SP.maSP
	LEFT JOIN CongDoan CD ON BPCCN.maCD = CD.maCD
WHERE trangThaiCN = 0 AND BPCCN.maBPCCN IS NOT NULL
GROUP BY 
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	HD.maHD,
	SP.maSP,
	BPCCN.maBPCCN, BPCCN.chiTieu, 
	BCCCN.maBCCCN,
	CD.maCD, CD.giaCongDoan,
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro;





--Tinh Luong COng nhan 

WITH ChiTietSoLuongLam AS (
SELECT
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	HD.maHD,
	SP.maSP,
	BPCCN.maBPCCN, BPCCN.chiTieu,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END ) AS diLam,
	BCCCN.maBCCCN, BCCCN.soLuongLamDuoc, 
	SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) AS tienCongCongDoan,
	SUM( CASE WHEN ( BPCCN.chiTieu <= BCCCN.soLuongLamDuoc ) THEN 1 ELSE 0 END ) AS nangSuat,
	SUM( CASE WHEN ( BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 ) THEN 1 ELSE 0 END ) AS phanTangCaCoDiLam,
	SUM( BCCCN.soLuongLamCa3) AS soLuongLamCa3,
	SUM( CASE WHEN ( BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 ) 
		THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) 
		ELSE 0 END) AS tienCongCongDoanTangCa,
	CD.maCD, CD.giaCongDoan,
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro
FROM CongNhan AS CN
	LEFT JOIN BangPhanCongCongNhan BPCCN ON CN.maCN = BPCCN.maCN AND MONTH(BPCCN.ngayKetThuc) = 12 AND YEAR(BPCCN.ngayKetThuc) = 2023 
	LEFT JOIN BangChamCongCongNhan BCCCN ON BPCCN.maBPCCN = BCCCN.maBPCCN AND MONTH(BCCCN.ngayChamCong) = 12 AND YEAR(BCCCN.ngayChamCong) = 2023 
	LEFT JOIN PhuCap PC ON CN.maPhuCap = PC.maPhuCap
	LEFT JOIN TamUngCongNhan TUCN ON CN.maCN = TUCN.maCN AND MONTH(TUCN.ngayTamUng) = 10 AND YEAR(TUCN.ngayTamUng) = 2023 
	LEFT JOIN ChucVu CV ON CN.maCV = CV.maCV
	LEFT JOIN ToSanXuat TSX ON CN.maTSX = TSX.maTSX
	LEFT JOIN HopDong HD ON BPCCN.maHD = HD.maHD
	LEFT JOIN ChiTietHopDong CTHD ON BPCCN.maHD = CTHD.maHD
	LEFT JOIN SanPham SP ON CTHD.maSP = SP.maSP
	LEFT JOIN CongDoan CD ON BPCCN.maCD = CD.maCD
WHERE trangThaiCN = 0 AND BPCCN.maBPCCN IS NOT NULL
GROUP BY 
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	HD.maHD,
	SP.maSP,
	BPCCN.maBPCCN, BPCCN.chiTieu, 
	BCCCN.maBCCCN, BCCCN.soLuongLamDuoc,  
	CD.maCD, CD.giaCongDoan,
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro
)

SELECT 
	CTSLL.maCN, CTSLL.hoCN, CTSLL.tenCN,
	CTSLL.tenTSX,
	CTSLL.maCV, CTSLL.heSoCV, 
	CTSLL.tienNangSuat, CTSLL.tienConNho, CTSLL.tienNhaTro,
	SUM((CTSLL.tienCongCongDoan + CTSLL.tienCongCongDoanTangCa) * CTSLL.heSoCV) AS tongLuongCN,
	SUM((CTSLL.tienCongCongDoan + CTSLL.tienCongCongDoanTangCa) * CTSLL.heSoCV) * 8.5 / 100 AS phiBHXH,
	SUM((CTSLL.tienCongCongDoan + CTSLL.tienCongCongDoanTangCa) * CTSLL.heSoCV) * 1.5 / 100 AS phiBHYT,
	SUM(CTSLL.diLam) AS soNgayDiLam,
	SUM(CTSLL.phanTangCaCoDiLam) soNgayTangCaDiLam,
	SUM(CTSLL.nghiPhep) 
	

FROM ChiTietSoLuongLam AS CTSLL
GROUP BY 
	CTSLL.maCN, CTSLL.hoCN, CTSLL.tenCN,
	CTSLL.tenTSX,
	CTSLL.maCV, CTSLL.heSoCV, 
	CTSLL.tienNangSuat, CTSLL.tienConNho, CTSLL.tienNhaTro;










		----Nhap Nay bi loi duplicate gia tri cuoi 

SELECT
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	SUM( BPCCN.chiTieu ) AS tongChiTieuPhanCong,
	SUM( BPCCN.chiTieu ) AS tongChiTieuPhanCong,
	SUM( BCCCN.soLuongLamDuoc) AS soLuongLamDuoc,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END) AS soNgayDiLam,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc = NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) AS soNgayNghi,
	SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END ) AS soNgayNghiPhep,
	SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) AS tienCongCongDoan,
	--CASE WHEN ( SUM(BCCCN.soLuongLamDuoc / BPCCN.chiTieu * 100)  ) THEN 1 ELSE 0 END AS nangSuat,
	SUM( CASE WHEN ( BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 ) THEN 1 ELSE 0 END ) AS phanTangCaCoDiLam,
	SUM( BCCCN.soLuongLamCa3) AS soLuongLamCa3,
	SUM( CASE WHEN ( BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 ) 
		THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) 
		ELSE 0 END) AS tienCongCongDoanTangCa,
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro
FROM CongNhan AS CN
	LEFT JOIN BangPhanCongCongNhan AS BPCCN ON CN.maCN = BPCCN.maCN AND MONTH(BPCCN.ngayKetThuc) = 12 AND YEAR(BPCCN.ngayKetThuc) = 2023 
	LEFT JOIN BangChamCongCongNhan AS BCCCN ON BPCCN.maBPCCN = BCCCN.maBPCCN AND MONTH(BCCCN.ngayChamCong) = 12 AND YEAR(BCCCN.ngayChamCong) = 2023 
	LEFT JOIN PhuCap AS PC ON CN.maPhuCap = PC.maPhuCap
	LEFT JOIN TamUngCongNhan AS TUCN ON CN.maCN = TUCN.maCN AND MONTH(TUCN.ngayTamUng) = 12 AND YEAR(TUCN.ngayTamUng) = 2023 
	LEFT JOIN ChucVu AS CV ON CN.maCV = CV.maCV
	LEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX
	LEFT JOIN HopDong AS HD ON BPCCN.maHD = HD.maHD
	LEFT JOIN ChiTietHopDong AS CTHD ON BPCCN.maHD = CTHD.maHD
	LEFT JOIN SanPham AS SP ON CTHD.maSP = SP.maSP
	LEFT JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
WHERE trangThaiCN = 0 AND BPCCN.maBPCCN IS NOT NULL
GROUP BY 
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro;

	

	---Khong bi duplicate gia tri 
SELECT
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	TUCN.soTienTamUng,
	TUCN.ngayTamUng,
	SUM( BPCCN.chiTieu ) AS tongChiTieuPhanCong,
	SUM( BCCCN.soLuongLamDuoc) AS soLuongLamDuoc,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END) AS soNgayDiLam,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) AS soNgayNghi,
	SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END ) AS soNgayNghiPhep,
	SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) AS tienCongCongDoan,
	SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN 1 ELSE 0 END ) AS phanTangCaCoDiLam,
	SUM( BCCCN.soLuongLamCa3) AS soLuongLamCa3,
	SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 
		THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) 
		ELSE 0 END
		) AS tienCongCongDoanTangCa,

	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100
	) AS phiBHXH,

	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100
	) AS phiBHYT,
	
	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV
	) AS tongLuongCN,

	(
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV) - 
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100) - 
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 1.5 / 100) -
        (
            CASE WHEN (
                SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) - 
                SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END )
            ) > -1 
            THEN (
			(SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) - 
                SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END )) * 50000) ELSE 0 END
		) +
		(COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)) +
		(CASE WHEN (SUM(BCCCN.soLuongLamDuoc) + SUM(BCCCN.soLuongLamCa3)) >= SUM(BPCCN.chiTieu) THEN PC.tienNangSuat ELSE 0 END) -
		(COALESCE(TUCN.soTienTamUng, 0))
	) AS luongNhanThucTe,
	CASE WHEN SUM( BPCCN.chiTieu) <= (SUM(BCCCN.soLuongLamCa3) + SUM(BCCCN.soLuongLamDuoc)) THEN PC.tienNangSuat ELSE 0 END AS tienNangSuat, 
	PC.tienConNho, PC.tienNhaTro
FROM CongNhan AS CN
	LEFT JOIN BangPhanCongCongNhan AS BPCCN ON CN.maCN = BPCCN.maCN AND MONTH(BPCCN.ngayKetThuc) = 12 AND YEAR(BPCCN.ngayKetThuc) = 2023 
	LEFT JOIN BangChamCongCongNhan AS BCCCN ON BPCCN.maBPCCN = BCCCN.maBPCCN AND MONTH(BCCCN.ngayChamCong) = 12 AND YEAR(BCCCN.ngayChamCong) = 2023 
	LEFT JOIN PhuCap AS PC ON CN.maPhuCap = PC.maPhuCap
	LEFT JOIN TamUngCongNhan AS TUCN ON CN.maCN = TUCN.maCN AND MONTH(TUCN.ngayTamUng) = 12 AND YEAR(TUCN.ngayTamUng) = 2023 
	LEFT JOIN ChucVu AS CV ON CN.maCV = CV.maCV
	LEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX
	LEFT JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
WHERE trangThaiCN = 0 AND BPCCN.maBPCCN IS NOT NULL
GROUP BY 
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro,
	TUCN.soTienTamUng, TUCN.ngayTamUng;


	--Loc bang luong cong nhan 
WITH ChiTietLuongCongNhan AS
(SELECT
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	TUCN.soTienTamUng,
	TUCN.ngayTamUng,
	SUM( BPCCN.chiTieu ) AS tongChiTieuPhanCong,
	SUM( BCCCN.soLuongLamDuoc) AS soLuongLamDuoc,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END) AS soNgayDiLam,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) AS soNgayNghi,
	SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END ) AS soNgayNghiPhep,
	SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) AS tienCongCongDoan,
	SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN 1 ELSE 0 END ) AS phanTangCaCoDiLam,
	SUM( BCCCN.soLuongLamCa3) AS soLuongLamCa3,
	SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 
		THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) 
		ELSE 0 END
		) AS tienCongCongDoanTangCa,

	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100
	) AS phiBHXH,

	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 1.5 / 100
	) AS phiBHYT,
	
	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV
	) AS tongLuongCN,

	(
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV) - 
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100) - 
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 1.5 / 100) -
        (
            CASE WHEN (
                SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) - 
                SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END )
            ) > -1 
            THEN (
			(SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) - 
                SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END )) * 50000) ELSE 0 END
		) +
		(COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)) +
		(CASE WHEN (SUM(BCCCN.soLuongLamDuoc) + SUM(BCCCN.soLuongLamCa3)) >= SUM(BPCCN.chiTieu) THEN PC.tienNangSuat ELSE 0 END) -
		(COALESCE(TUCN.soTienTamUng, 0))
	) AS luongNhanThucTe,
	CASE WHEN SUM( BPCCN.chiTieu) <= (SUM(BCCCN.soLuongLamCa3) + SUM(BCCCN.soLuongLamDuoc)) THEN PC.tienNangSuat ELSE 0 END AS tienNangSuat, 
	PC.tienConNho, PC.tienNhaTro,
	MONTH(BCCCN.ngayChamCong) AS thangChamCong,
	YEAR(BCCCN.ngayChamCong) AS namChamCong

FROM CongNhan AS CN
	LEFT JOIN BangPhanCongCongNhan AS BPCCN ON CN.maCN = BPCCN.maCN-- AND MONTH(BPCCN.ngayKetThuc) = 12 AND YEAR(BPCCN.ngayKetThuc) = 2023 
	LEFT JOIN BangChamCongCongNhan AS BCCCN ON BPCCN.maBPCCN = BCCCN.maBPCCN-- AND MONTH(BCCCN.ngayChamCong) = 12 AND YEAR(BCCCN.ngayChamCong) = 2023 
	LEFT JOIN PhuCap AS PC ON CN.maPhuCap = PC.maPhuCap
	LEFT JOIN TamUngCongNhan AS TUCN ON CN.maCN = TUCN.maCN --AND MONTH(TUCN.ngayTamUng) = 12 AND YEAR(TUCN.ngayTamUng) = 2023 
	LEFT JOIN ChucVu AS CV ON CN.maCV = CV.maCV
	LEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX
	LEFT JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
WHERE trangThaiCN = 0 AND BPCCN.maBPCCN IS NOT NULL
GROUP BY 
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro,
	TUCN.soTienTamUng, TUCN.ngayTamUng, MONTH(BCCCN.ngayChamCong), YEAR(BCCCN.ngayChamCong)
)
SELECT *
FROM ChiTietLuongCongNhan AS CTLCN
WHERE CTLCN.thangChamCong = '12' AND namChamCong = '2023' 


--Them bang luong de ghi nhan tinh luong

INSERT INTO BangLuongCongNhan(maBLCN, luongCN, tongLuongCN, ngayTinhLuong, ngayNhanLuong, trangThaiLuong)
VALUES (?, ?, ?, ?, ?)

SELECT BLCN.*
FROM BangLuongCongNhan AS BLCN
WHERE BLCN.maBLCN = 'BLCN100007122023';


--Loc cac bang luong da tao roi

WITH ChiTietLuongCongNhan AS
(SELECT
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	TUCN.soTienTamUng,
	TUCN.ngayTamUng,
	SUM( BPCCN.chiTieu ) AS tongChiTieuPhanCong,
	SUM( BCCCN.soLuongLamDuoc) AS soLuongLamDuoc,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END) AS soNgayDiLam,
	SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) AS soNgayNghi,
	SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END ) AS soNgayNghiPhep,
	SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) AS tienCongCongDoan,
	SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN 1 ELSE 0 END ) AS phanTangCaCoDiLam,
	SUM( BCCCN.soLuongLamCa3) AS soLuongLamCa3,
	SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 
		THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) 
		ELSE 0 END
		) AS tienCongCongDoanTangCa,

	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100
	) AS phiBHXH,

	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 1.5 / 100
	) AS phiBHYT,
	
	((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + 
		SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV
	) AS tongLuongCN,

	(
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV) - 
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100) - 
		((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 1.5 / 100) -
        (
            CASE WHEN (
                SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) - 
                SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END )
            ) > -1 
            THEN (
			(SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) - 
                SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END )) * 50000) ELSE 0 END
		) +
		(COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)) +
		(CASE WHEN (SUM(BCCCN.soLuongLamDuoc) + SUM(BCCCN.soLuongLamCa3)) >= SUM(BPCCN.chiTieu) THEN PC.tienNangSuat ELSE 0 END) -
		(COALESCE(TUCN.soTienTamUng, 0))
	) AS luongNhanThucTe,
	CASE WHEN SUM( BPCCN.chiTieu) <= (SUM(BCCCN.soLuongLamCa3) + SUM(BCCCN.soLuongLamDuoc)) THEN PC.tienNangSuat ELSE 0 END AS tienNangSuat, 
	PC.tienConNho, PC.tienNhaTro,
	MONTH(BCCCN.ngayChamCong) AS thangChamCong,
	YEAR(BCCCN.ngayChamCong) AS namChamCong

FROM CongNhan AS CN
	LEFT JOIN BangPhanCongCongNhan AS BPCCN ON CN.maCN = BPCCN.maCN-- AND MONTH(BPCCN.ngayKetThuc) = 12 AND YEAR(BPCCN.ngayKetThuc) = 2023 
	LEFT JOIN BangChamCongCongNhan AS BCCCN ON BPCCN.maBPCCN = BCCCN.maBPCCN-- AND MONTH(BCCCN.ngayChamCong) = 12 AND YEAR(BCCCN.ngayChamCong) = 2023 
	LEFT JOIN PhuCap AS PC ON CN.maPhuCap = PC.maPhuCap
	LEFT JOIN TamUngCongNhan AS TUCN ON CN.maCN = TUCN.maCN --AND MONTH(TUCN.ngayTamUng) = 12 AND YEAR(TUCN.ngayTamUng) = 2023 
	LEFT JOIN ChucVu AS CV ON CN.maCV = CV.maCV
	LEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX
	LEFT JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
WHERE trangThaiCN = 0 AND BPCCN.maBPCCN IS NOT NULL
GROUP BY 
	CN.maCN, CN.hoCN, CN.tenCN,
	TSX.tenTSX,
	CV.maCV, CV.heSoCV, 
	PC.tienNangSuat, PC.tienConNho, PC.tienNhaTro,
	TUCN.soTienTamUng, TUCN.ngayTamUng, MONTH(BCCCN.ngayChamCong), YEAR(BCCCN.ngayChamCong)
)
SELECT *
FROM ChiTietLuongCongNhan AS CTLCN
	LEFT JOIN BangLuongCongNhan AS BLCN ON CTLCN.maCN = BLCN.maCN
WHERE CTLCN.thangChamCong = '12' AND namChamCong = '2023' AND BLCN.maBLCN IS NULL



--Loc bang luong nhan vien
SELECT BLCN.*, CN.tenCN, CN.hoCN, TSX.tenTSX
FROM BangLuongCongNhan AS BLCN
	LEFT JOIN CongNhan AS CN ON CN.maCN = BLCN.maCN
	LEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX
WHERE CN.tenCN. = 'CN100007'

--CapNhat luong
UPDATE BangLuongCongNhan SET ngayNhanLuong = '2023-12-12', trangThaiLuong = 1 WHERE maBLCN = 'BLCN100007122023';


--Tinh luong nhan vien loc 

WITH ChiTietLuongNhanVien AS (
SELECT 
    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan,
	TUNV.soTienTamUng, TUNV.ngayTamUng,
    CV.heSoCV,
    PB.tenPB,
    PC.tienConNho,
    PC.tienNhaTro,
	(
		CASE WHEN ( SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) -
			SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) )
			> -1 THEN PC.tienChuyenCan
			ELSE 0 END
	) AS tienChuyenCan,
    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,
    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) AS soNgayNghi,
    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,
    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,

	MONTH(BCCNV.ngayChamCong) AS thangChamCong,
	YEAR(BCCNV.ngayChamCong) AS namChamCong,
	
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,
    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,
    (
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV
        ) +
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV
        ) +
        (
            COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)
        ) -
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100
        ) - 
        (
            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100
        ) - 
        (
             COALESCE(TUNV.soTienTamUng, 0)
        ) -
        (
            CASE WHEN (
                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - 
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)
            ) > -1 
            THEN (
                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - 
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)
            ) * 50000
            ELSE 0 
            END
        ) +
        (
            CASE WHEN
                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) = 0 
            THEN PC.tienChuyenCan
            ELSE 0 
            END
        )
    ) AS luongThucTe
FROM 
	NhanVien AS NV
LEFT JOIN 
    BangChamCongNhanVien AS BCCNV ON NV.maNV = BCCNV.maNV --AND MONTH(BCCNV.ngayChamCong) = 12 AND YEAR(BCCNV.ngayChamCong) = 2023 
LEFT JOIN
    PhongBan AS PB ON PB.maPB = NV.maPB
LEFT JOIN 
    ChucVu AS CV ON NV.maCV = CV.maCV
LEFT JOIN 
    PhuCap AS PC ON NV.maPhuCap = PC.maPhuCap
LEFT JOIN 
    TamUngNhanVien AS TUNV ON NV.maNV = TUNV.maNV --AND MONTH(TUNV.ngayTamUng) = 12 AND YEAR(TUNV.ngayTamUng) = 2023 
GROUP BY 
    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, PB.tenPB,TUNV.soTienTamUng, TUNV.ngayTamUng,
	PC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro, MONTH(BCCNV.ngayChamCong), YEAR(BCCNV.ngayChamCong)
)
SELECT *
FROM ChiTietLuongNhanVien AS CTLNV
	LEFT JOIN BangLuongNhanVien AS BLNV ON CTLNV.maNV = BLNV.maNV
WHERE CTLNV.thangChamCong = 11 AND CTLNV.namChamCong = 2023 


--THem bang luong nhan vien de xac nhan chi tra luong 

INSERT INTO BangLuongNhanVien(maBLNV, maNV, luongNV, tongLuongNV, ngayTinhLuong, ngayNhanLuong)
VALUES (?, ?, ?, ?, ?)

SELECT BLCN.*
FROM BangLuongCongNhan AS BLCN
WHERE BLCN.maBLCN = 'BLCN100007122023';


SELECT BLNV.*, NV.tenNV, NV.hoNV, PB.tenPB
                FROM BangLuongNhanVien AS BLNV
                LEFT JOIN NhanVien AS NV ON NV.maNV = BLNV.maNV
                LEFT JOIN PhongBan AS PB ON NV.maPB = PB.maPB

--Lay du lieu chi tiet hop dong

SELECT HD.*, CTHD.maSP, CTHD.soLuongDat, CTHD.soLuongDaLam--, SP.tenSP, SP.giaSP
                FROM HopDong AS HD
                LEFT JOIN ChiTietHopDong AS CTHD ON HD.maHD = CTHD.maHD
                --LEFT JOIN SanPham AS SP ON CTHD.maSP = SP.maSP
				--LEFT JOIN CongDoan AS CD ON CTHD.maSP = CD.maSP
                WHERE HD.maHD = 'HD100033'

SELECT HD.*, CTHD.maSP, CTHD.soLuongDat, CTHD.soLuongDaLam, SP.tenSP, SP.giaSP, CD.SoLuongCongDoan
FROM HopDong AS HD
JOIN ChiTietHopDong AS CTHD ON HD.maHD = CTHD.maHD
JOIN SanPham AS SP ON CTHD.maSP = SP.maSP
JOIN (
    SELECT maSP, COUNT(*) AS SoLuongCongDoan
    FROM CongDoan
    GROUP BY maSP
) AS CD ON SP.maSP = CD.maSP
WHERE HD.maHD = 'HD100033'

SELECT CTHD.*, COUNT(C
	FROM ChiTietHopDong AS CTHD
	LEFT JOIN SanPham AS SP ON CTHD.maSP = SP.maSP
	LEFT JOIN CongDoan AS CD ON CTHD.maSP = CD.maSP
	WHERE CTHD.maHD = 'HD100033'

--Xem chi tiet cong san pham cua hop dong hoan thanh
SELECT CTHD.*, SP.tenSP, SP.giaSP, COALESCE(CD.soLuongCongDoan, 0) AS soLuongCongDoan
FROM ChiTietHopDong AS CTHD
LEFT JOIN SanPham AS SP ON CTHD.maSP = SP.maSP
LEFT JOIN (
    SELECT maSP, COUNT(*) AS soLuongCongDoan
    FROM CongDoan
    GROUP BY maSP
) AS CD ON CTHD.maSP = CD.maSP
WHERE CTHD.maHD = 'HD100033'


SELECT HD.* 
FROM HopDong AS HD 
WHERE HD.trangThaiHD = 1 AND HD.ngayKKHD BETWEEN '2022-12-02' AND '2024-12-3' OR HD.ngayTLHD BETWEEN '' AND ''


--Cap nhat so luong san pham khi cham cong nhan vien
UPDATE ChiTietHopDong
SET soLuongDaLam = (
		SELECT SUM(CD.giaCongDoan) 
		FROM BangPhanCongCongNhan AS BPCCN WHERE BPCCN.maCD = ?
	)
WHERE maSP = ?
AND (
SELECT giaSP FROM SanPham WHERE maSP = ?
) <> (
SELECT SUM(CD.giaCongDoan) FROM CongDoan AS CD WHERE CD.maSP = ?)


WITH Temp AS (SELECT *
FROM BangChamCongCongNhan AS BCCCN
JOIN BangPhanCongCongNhan AS BPCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN
JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
JOIN SanPham AS SP ON CD.maSP = SP.maSP
WHERE CD.giaiDoan = N'Cắt'
)
SELECT T.*
FROM Temp AS T

SELECT CD.maCD, CD.giaiDoan
FROM CongDoan AS CD 
WHERE CD.giaiDoan= N'Đóng gói'



UPDATE ChiTietHopDong
SET soLuongDaLam = ChiTietHopDong.soLuongDaLam + BCCCN.totalLam
FROM ChiTietHopDong AS ChiTietHopDong
JOIN (
    SELECT BPCCN.maHD, SUM(BCCCN.soLuongLamDuoc + BCCCN.soLuongLamCa3) AS totalLam
    FROM BangChamCongCongNhan AS BCCCN
    JOIN BangPhanCongCongNhan AS BPCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN
    JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
    WHERE CD.giaiDoan = N'Đóng gói'
    GROUP BY BPCCN.maHD
) AS BCCCN ON ChiTietHopDong.maHD = BCCCN.maHD
WHERE ChiTietHopDong.maHD = BCCCN.maHD;

HD100034	0
HD100039	180
HD100050	370


--Oke cap nhat gia tri 
UPDATE ChiTietHopDong
SET soLuongDaLam = ChiTietHopDong.soLuongDaLam + BCCCN.tongSoLuongLam
FROM ChiTietHopDong AS ChiTietHopDong
JOIN (
    SELECT BPCCN.maHD, SUM(BCCCN.soLuongLamDuoc + BCCCN.soLuongLamCa3) AS tongSoLuongLam, CD.maSP
    FROM BangChamCongCongNhan AS BCCCN
    JOIN BangPhanCongCongNhan AS BPCCN ON BPCCN.maBPCCN = 'PCCN100004111223' AND BCCCN.maBCCCN = 'CCCN100004111223'
    JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
    WHERE CD.giaiDoan = N'Đóng gói'
    GROUP BY BPCCN.maHD, CD.maSP
) AS BCCCN ON ChiTietHopDong.maHD = BCCCN.maHD 
WHERE ChiTietHopDong.maHD = BCCCN.maHD AND ChiTietHopDong.maSP = BCCCN.maSP;



--Khong the update giam do  khong dung rollback 
UPDATE ChiTietHopDong
SET soLuongDaLam = 
    CASE
        WHEN ChiTietHopDong.soLuongDaLam + BCCCN.tongSoLuongLam < ChiTietHopDong.soLuongDaLam THEN 0 -- Nếu giảm so với ban đầu, cập nhật thành 0
        ELSE ChiTietHopDong.soLuongDaLam + BCCCN.tongSoLuongLam -- Nếu không giảm, cộng dồn bình thường
    END
FROM ChiTietHopDong AS ChiTietHopDong
JOIN (
    SELECT BPCCN.maHD, SUM(BCCCN.soLuongLamDuoc + BCCCN.soLuongLamCa3) AS tongSoLuongLam, CD.maSP
    FROM BangChamCongCongNhan AS BCCCN
    JOIN BangPhanCongCongNhan AS BPCCN ON BPCCN.maBPCCN = 'PCCN100004111223' AND BCCCN.maBCCCN = 'CCCN100004111223'
    JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
    WHERE CD.giaiDoan = N'Đóng gói'
    GROUP BY BPCCN.maHD, CD.maSP
) AS BCCCN ON ChiTietHopDong.maHD = BCCCN.maHD 
WHERE ChiTietHopDong.maHD = BCCCN.maHD AND ChiTietHopDong.maSP = BCCCN.maSP;


SELECT * 
FROM TaiKhoan 
WHERE maTK = 'NV100000' AND matKhau = '123456'

SELECT NV.maNV, (NV.hoNV + ' ' + NV.tenNV) AS hoTenNV, PB.tenPB, PB.maPB, CV.tenCV, CV.maCV, TK.vaiTro
FROM TaiKhoan AS TK 
	JOIN NhanVien AS NV ON NV.maNV = TK.maTK
	JOIN PhongBan AS PB ON PB.maPB = NV.maPB
	JOIN ChucVu AS CV ON CV.maCV = NV.maCV
WHERE NV.maNV = 'NV100001'



UPDATE ChiTietHopDong
SET soLuongDaLam = ChiTietHopDong.soLuongDaLam + BCCCN.tongSoLuongLam
FROM ChiTietHopDong AS ChiTietHopDong
JOIN (
    SELECT BPCCN.maHD, SUM(BCCCN.soLuongLamDuoc + BCCCN.soLuongLamCa3) AS tongSoLuongLam, CD.maSP
    FROM BangChamCongCongNhan AS BCCCN
    JOIN BangPhanCongCongNhan AS BPCCN ON BPCCN.maBPCCN = 'PCCN100007111223' AND BCCCN.maBCCCN = 'CCCN100007111223'
    JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD
    WHERE CD.giaiDoan = N'Đóng gói'
    GROUP BY BPCCN.maHD, CD.maSP
) AS BCCCN ON ChiTietHopDong.maHD = BCCCN.maHD 
WHERE ChiTietHopDong.maHD = BCCCN.maHD AND ChiTietHopDong.maSP = BCCCN.maSP;




