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

select * from
PhuCap