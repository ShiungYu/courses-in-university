import numpy as np
import cv2
img=cv2.imread("blob.jfif",0)
tempimage=np.zeros(shape=(512,512))
DitherArray=[[0.513,0.272,0.724,0.483,0.543,0.302,0.694,0.453],
 [0.151,0.755,0.091,0.966,0.181,0.758,0.121,0.936],
 [0.634,0.392,0.574,0.332,0.664,0.423,0.604,0.362],
 [0.060,0.875,0.211,0.815,0.030,0.906,0.241,0.845],
 [0.543,0.302,0.694,0.453,0.513,0.272,0.724,0.483],
 [0.181,0.758,0.121,0.936,0.151,0.755,0.091,0.936],
 [0.664,0.423,0.604,0.362,0.634,0.392,0.574,0.332],
 [0.030,0.906,0.241,0.845,0.060,0.875,0.211,0.815]]
for i in range(0,512,8):
    for j in range(0,512,8):
        x,y=0,0
        for x in range(0,8):
            for y in range(0,8):
                tempnumber=img[i+x][j+y]/255.0
                if tempnumber<DitherArray[x][y]:
                    tempimage[i+x][j+y]=0
                else:
                    tempimage[i+x][j+y]=255 
cv2.imwrite("Ordered Dithering Lena.jpg", tempimage)                     
cv2.imshow('My Image', tempimage)
cv2.waitKey(0)
cv2.destroyAllWindows()
