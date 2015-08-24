;; answer with y/n
(fset 'yes-or-no-p 'y-or-n-p)

;;shuts of the fking annoying bell-sounds
(setq ring-bell-function 'ignore)

;; kills the active buffer, not asking what buffer to kill.
(global-set-key (kbd "C-x k") 'kill-this-buffer)

;; adds all autosave-files (i.e #test.txt#, test.txt~) in one
;; directory, avoid clutter in filesystem.
(defvar emacs-autosave-directory (concat user-emacs-directory "autosaves/"))
(setq backup-directory-alist
      `((".*" . ,emacs-autosave-directory))
      auto-save-file-name-transforms
      `((".*" ,emacs-autosave-directory t)))

;; defining a function that sets more accessible keyboard-bindings to
;; hiding/showing code-blocs
(defun hideshow-on ()
  (local-set-key (kbd "C-c <right>") 'hs-show-block)
  (local-set-key (kbd "C-c <left>")  'hs-hide-block)
  (local-set-key (kbd "C-c <up>")    'hs-hide-all)
  (local-set-key (kbd "C-c <down>")  'hs-show-all)
  (hs-minor-mode t))

;; now we have to tell emacs where to load these functions. Showing
;; and hiding codeblocks could be useful for all c-like programming
;; (java is c-like) languages, so we add it to the c-mode-common-hook.
(add-hook 'c-mode-common-hook 'hideshow-on)

;; adding shortcuts to java-mode, writing the shortcut folowed by a
;; non-word character will cause an expansion.
(defun java-shortcuts ()
  (define-abbrev-table 'java-mode-abbrev-table
    '(("psv" "public static void main(String[] args) {" nil 0)
      ("sop" "System.out.printf" nil 0)
      ("sopl" "System.out.println" nil 0)))
  (abbrev-mode t))

;; the shortcuts are only useful in java-mode so we'll load them to
;; java-mode-hook.
(add-hook 'java-mode-hook 'java-shortcuts)

;; defining a function that guesses a compile command and bindes the
;; compile-function to C-c C-c
(defun java-setup ()
  (set (make-variable-buffer-local 'compile-command)
       (concat "javac " (buffer-name)))
  (local-set-key (kbd "C-c C-c") 'compile))

;; this is a java-spesific function, so we only load it when entering
;; java-mode
(add-hook 'java-mode-hook 'java-setup)

;; defining a function that sets the right indentation to the marked
;; text, or the entire buffer if no text is selected.
(defun tidy ()
  "Ident, untabify and unwhitespacify current buffer, or region if active."
  (interactive)
  (let ((beg (if (region-active-p) (region-beginning) (point-min)))
        (end (if (region-active-p) (region-end)       (point-max))))
    (whitespace-cleanup)
    (indent-region beg end nil)
    (untabify beg end)))

;; bindes the tidy-function to C-TAB
(global-set-key (kbd "<C-tab>") 'tidy)

;; enable ido-mode, changes the way files are selected in the minibuffer
(ido-mode 1)

;; use ido everywhere
(ido-everywhere 1)

;; show vertically
(ido-vertical-mode 1)

;;Makes it possible to switch windows with arrowkeys
(windmove-default-keybindings 'meta)

;;adds relative line numbers
(global-relative-line-numbers-mode 1)
