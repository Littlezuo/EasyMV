实现fragment的懒加载
图片的高斯模糊
navigationview的使用
mvvm
用retrofit做网络请求,当参数很多的时候,建议使用@body传递参数，@body 是把bean转换成json字符串传递过去

下载更新app地址后面出现出现空格,在某些app上会报错.

GLide 图片会变成绿色 ,使用 .diskCacheStrategy(DiskCacheStrategy.SOURCE)解决
图片变色的原因是因为图片压缩所致，一半是webp会出现这样的情况。
所以在使用Glide的缓存机制的时候，缓存原图片即可。

优化:
对于过于大的图片可以通过AndroidStudiov转换成webp,可以大大的减小app大小

