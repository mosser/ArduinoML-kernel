module Paths_ArduinoHS (
    version,
    getBinDir, getLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
catchIO = Exception.catch

version :: Version
version = Version [0,2,0,0] []
bindir, libdir, datadir, libexecdir, sysconfdir :: FilePath

bindir     = "/Users/berewt/.cabal/bin"
libdir     = "/Users/berewt/.cabal/lib/x86_64-osx-ghc-7.10.1/Ardui_9kFEGIt5Uhj8FlUVETtFBL"
datadir    = "/Users/berewt/.cabal/share/x86_64-osx-ghc-7.10.1/ArduinoHS-0.2.0.0"
libexecdir = "/Users/berewt/.cabal/libexec"
sysconfdir = "/Users/berewt/.cabal/etc"

getBinDir, getLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "ArduinoHS_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "ArduinoHS_libdir") (\_ -> return libdir)
getDataDir = catchIO (getEnv "ArduinoHS_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "ArduinoHS_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "ArduinoHS_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
