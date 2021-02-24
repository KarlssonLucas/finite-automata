type Set = (String, String, String, String) 

run :: Int -> Int -> IO ()
run i j = mapM_ printset $ derive i j [("","P","P","")]

derive :: Int -> Int -> [Set] -> [Set]
derive 0 0 sets = tail $ sets ++ [(removeP $ last sets)] 
                where removeP (x,y,z,v) = (x,x++z++v,[c | c <- z, c /= 'P'], v)

derive i j sets | i > 0 = derive (i-1) j $ sets ++ [deriveset "a" $ last sets]
                | j > 0 = derive i (j-1) $ sets ++ [deriveset "b" $ last sets]

deriveset :: String -> Set -> Set
deriveset "a" (x,y,z,v) = ("a", old, old, "b") where old = x++y++v
deriveset "b" (x,y,z,v) = ("", old, old, "b") where old = x++y++v

printset :: Set -> IO () 
printset (x,y,z,v) = putStrLn (y++" => "++x++z++v)
