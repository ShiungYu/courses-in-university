from skimage import io
import numpy as np
import matplotlib.pyplot as plt
import scipy.ndimage as ndi
c=io.imread('cameraman.tif')
cd=c.astype(np.float64)
f=np.array([[1,0,0],[0,1,0],[0,0,1]])/3
cdm=ndi.convolve(cd,f)
cd2f=ndi.convolve(cd**2,f)
cdv=cd2f-cdm**2
for x in range(1,255):
    for y in range(1,255):
        minn=min(cdv[x-1][y-1],cdv[x-1][y+1],cdv[x+1][y-1],cdv[x+1][y+1])
        if cdv[x-1][y-1]==minn:
            cd[x][y]=cdm[x-1][y-1]
        elif cdv[x-1][y+1]==minn:
            cd[x][y]=cdm[x-1][y+1]
        elif cdv[x+1][y-1]==minn:
            cd[x][y]=cdm[x+1][y-1]
        elif cdv[x+1][y+1]==minn:
            cd[x][y]=cdm[x+1][y+1]  
fig = plt.figure()
cd.astype(np.uint8)
plt.gray()  # show the filtered result in grayscale
ax1 = fig.add_subplot(121)  # left side
ax2 = fig.add_subplot(122)  # right side

ax1.imshow(c/255,vmax=1.0,vmin=0.0)
ax2.imshow(cd/255,vmax=1.0,vmin=0.0)
io.imsave('kuwa.jpg',cd)
plt.show()
print(cd.shape[0])