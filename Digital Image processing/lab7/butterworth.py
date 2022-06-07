from skimage import io
from numpy.fft import *
from skimage import exposure
import numpy as np
import matplotlib.pyplot as plt
import time
c = io.imread('blob.jfif',1)
cf = fftshift(fft2(c))
ar = np.arange(-256,256)
start=time.time()
x,y = np.meshgrid(ar,ar)
D=15.0
bh = 1-1.0/(1.0+((x**2+y**2)/D**2)**2)
cfbh = cf*bh
cfbhfft = exposure.rescale_intensity(np.log(1+abs(cfbh)), out_range=(0.0, 1.0))
end=time.time()
print(end-start)
fig = plt.figure()
ax1 = fig.add_subplot(121)
ax1.imshow(cfbhfft,cmap='gray')
ax2 = fig.add_subplot(122)
ax2.imshow(np.abs(ifft2(cfbh)), cmap='gray')
plt.show()
