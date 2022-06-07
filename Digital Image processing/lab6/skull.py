from skimage import io
from skimage import transform
import matplotlib.pyplot as plt

a = io.imread('ambassadors.jpg')
print(a.shape)
skull = a[751:1021,157:750]
skull=transform.rotate(skull,-25,order=2)
skull=transform.resize(skull,(740,216))
skull=skull[350:555,15:215]
skull=transform.rotate(skull,25,order=2)

fig = plt.figure()
plt.gray()  # show the filtered result in grayscale
ax1 = fig.add_subplot(121)  # left side
ax2 = fig.add_subplot(122)  # right side

ax1.imshow(a)
ax2.imshow(skull)

plt.show()
