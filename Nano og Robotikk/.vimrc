set nocompatible
filetype off

set rtp+=~/.vim/bundle/Vundle.vim
call vundle#begin()

Plugin 'VundleVim/Vundle.vim'
Plugin 'Lokaltog/vim-powerline'
Plugin 'easymotion/vim-easymotion'
Plugin 'flazz/vim-colorschemes'
Plugin 'scrooloose/nerdtree'
Plugin 'vim-scripts/L9'
Plugin 'vim-scripts/FuzzyFinder'
"Plugin 'wincent/Command-T'
"Plugin 'kien/ctrlp.vim'

call vundle#end()
filetype plugin indent on

let mapleader = ","

syntax enable " enables syntax (duh)
set laststatus=2 "makes powerline visible in all buffers
set tabstop=2 softtabstop=0 noexpandtab shiftwidth=2 "fixes tabs to be 2 spaces

colorscheme gruvbox
set background=dark
set number

:set guioptions-=m  "remove menu bar
:set guioptions-=T  "remove toolbar
:set guioptions-=r  "remove right-hand scroll bar
:set guioptions-=L  "remove left-hand scroll bar

set tabstop=2 softtabstop=0 noexpandtab shiftwidth=2

set showcmd "shwo unfinished comments
set scrolloff=3 "keeps 3 lines when scrolling
set hlsearch "highlifht searches

:nmap <M-z> :NERDTreeToggle <Enter> 
:nmap <C-a> gg=G
:nnoremap <leader>ev :vsplit $MYVIMRC<cr>
:nnoremap <leader>sv :source $MYVIMRC<cr>
:nnoremap <leader>wf :w<cr>
:nnoremap <C-i> :vertical resize +10<cr>
:nnoremap <C-d> :vertical resize -10<cr>
:inoremap jk <esc>

:iabbrev sopl System.out.println 

nnoremap <silent> <C-1> :noh1<cr><C-1>
