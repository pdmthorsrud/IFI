
;; adding monokai-theme
(load-theme 'monokai t)

;; no splash screen
(setq inhibit-splash-screen t)

;; show matching parenthesis
(show-paren-mode 1)

;; show column number in mode-line
(column-number-mode 1)

;; stop blinking cursor
(blink-cursor-mode 0)

;; no menubar
(menu-bar-mode 0)

;; no toolbar either
(tool-bar-mode 0)

;; scrollbar? no
(scroll-bar-mode 0)

;; global-linum-mode shows line numbers in all buffers, exchange 0
;; with 1 to enable this feature
(global-linum-mode 0)

;;sets the cursor to a line
(setq-default cursor-type 'bar) 

