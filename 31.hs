module ASS01 where

g [] = 1
g (0:ls) = length ls + g ls - h ls
h [] = 0
h (0:ls) = length ls + g ls
f [] = 1
f (0:ls) = h ls + 2 * g ls
