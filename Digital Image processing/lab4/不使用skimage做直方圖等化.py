import numpy as np
import cv2 as cv
from matplotlib import pyplot as plt
from skimage.util import img_as_ubyte
from skimage import data
img = img_as_ubyte(data.moon())
equ = cv.equalizeHist(img)
res = np.hstack((img,equ)) #stacking images side-by-side
cv.imwrite('moon.png',res)
cv.imshow('my img',res)
cv.waitKey(0)