import skimage as sk
import numpy as np
import cv2
import copy
img=cv2.imread("blob.jfif",0)
halftoneimage=  np.zeros(shape=(512,512))
errorarry=[[0.0,    0.0,     0.0,     0.19040, 0.095230],
 [0.04762,0.095230,0.19040, 0.095230,0.04762 ],
 [0.02381,0.047620,0.095230,0.047620,0.02381]]
for i in range(0,512):
    for j in range(0,512):
        halftoneimage[i][j]=img[i][j]
for i in range(0,512):
    for j in range(0,512):
        if halftoneimage[i][j]<128:
            errorvalue=halftoneimage[i][j]
            halftoneimage[i][j]=0
        else:
            errorvalue=halftoneimage[i][j]-255
            halftoneimage[i][j]=255
        for x in range (0,3):
            if i+x<0 or i+x>=512:
                continue
            for y in range(-2,3):
                if j+y<0 or j+y>=512:
                    continue
                if  errorarry[x][y+2]==0:
                    continue
                weightvalue=errorarry[x][y+2]*errorvalue
                halftoneimage [i+x][j+y]+=weightvalue
cv2.imshow('My Image', halftoneimage)
cv2.imwrite("Error Diffusion Lena.jpg", halftoneimage)                     
cv2.waitKey(0)
cv2.destroyAllWindows()