;; we can require features
(require 'cl)
(require 'package)

;; add mirrors for list-packages
(setq package-archives '(("gnu" . "http://elpa.gnu.org/packages/")
                         ("melpa" . "http://melpa.milkbox.net/packages/")))

;; needed to use things downloaded with the package manager
(package-initialize)


;; install some packages if missing
(let* ((packages '(auto-complete
                   ido-vertical-mode
                   monokai-theme
                   multiple-cursors
                   undo-tree
		   yasnippet
		   java-snippets
		   magit
		   auto-complete
		   2048-game
		   undo-tree
		   relative-line-numbers
		   zenburn-theme
                   ;; if you want more packages, add them here
                   ))
       (packages (remove-if 'package-installed-p packages)))
  (when packages
    (package-refresh-contents)
    (mapc 'package-install packages)))
