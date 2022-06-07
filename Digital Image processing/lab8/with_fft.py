from skimage import io,util, exposure
import matplotlib.pyplot as plt
from numpy.fft import *
import numpy as np
import time
h = io.imread('Lena.png',1)
r,c = h.shape
x,y =np.mgrid[-c/2:c/2,-r/2:r/2].astype('float32')
bworth = 1./(1+(np.sqrt(2)-1)*((x**2+y**2) /15**2)**2)
hf = fftshift(fft2(h))
hw=hf*bworth
hwa = np.abs(ifft2(hw))
blur = util.img_as_ubyte(exposure.rescale_intensity(hwa,out_range=(0.0,1.0)))
blur = util.noise.random_noise(blur,mode ='gaussian')
k=0.01
start=time.time()
bf=fftshift(fft2(blur))
w1=bf*(abs(bworth)**2/(abs(bworth)**2+k)/bworth)
wla=abs(ifft2(w1))
end=time.time()
print(end-start)
fig = plt.figure()
ax3 = fig.add_subplot(131)
ax3.imshow(h,cmap='gray')
ax1 = fig.add_subplot(132)
ax1.imshow(blur,cmap='gray')
ax2 = fig.add_subplot(133)
ax2.imshow(wla,cmap='gray')
plt.show()
