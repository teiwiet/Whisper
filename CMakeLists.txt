cmake_minimum_required(VERSION 3.29.5)

project(Whisper
	VERSION 1.0.0
	LANGUAGES C CXX 
)

set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

#custom variable
set(WHISPSER_GAME_TARGET_NAME WhisperGame)

#add_executable(${WHISPSER_GAME_TARGET_NAME}
#	${CMAKE_CURRENT_SOURCE_DIR}/Whisper/src/main.cpp
#)

add_subdirectory(Whisper)
