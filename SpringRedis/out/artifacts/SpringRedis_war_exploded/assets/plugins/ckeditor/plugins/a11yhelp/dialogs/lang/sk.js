﻿/*
 Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 For licensing, see LICENSE.md or http://ckeditor.com/license
 */
CKEDITOR.plugins.setLang("a11yhelp", "sk", {
 title: "Inštrukcie prístupnosti",
 contents: "Pomocný obsah. Pre zatvorenie tohto okna, stlačte ESC.",
 legend: [{
  name: "Všeobecne",
  items: [{
   name: "Lišta nástrojov editora",
   legend: "Stlačte ${toolbarFocus} pre navigáciu na lištu nástrojov. Medzi ďalšou a predchádzajúcou lištou nástrojov sa pohybujete s TAB a SHIFT-TAB. Medzi ďalším a predchádzajúcim tlačidlom na lište nástrojov sa pohybujete s pravou šípkou a ľavou šípkou. Stlačte medzerník alebo ENTER pre aktiváciu tlačidla lišty nástrojov."
  },
   {
    name: "Editorový dialóg",
    legend: "V dialogu, stlačte TAB pre navigáciu na ďalšie dialógové pole, stlačte STIFT + TAB pre presun na predchádzajúce pole, stlačte ENTER pre odoslanie dialógu, stlačte ESC pre zrušenie dialógu. Pre dialógy, ktoré majú viac záložiek, stlačte ALT + F10 pre navigácou do zoznamu záložiek. Potom sa posúvajte k ďalšej žáložke pomocou TAB alebo pravou šípkou. Pre presun k predchádzajúcej záložke, stlačte SHIFT + TAB alebo ľavú šípku. Stlačte medzerník alebo ENTER pre vybranie záložky."
   },
   {
    name: "Editorové kontextové menu",
    legend: "Stlačte ${contextMenu} alebo APPLICATION KEY pre otvorenie kontextového menu. Potom sa presúvajte na ďalšie možnosti menu s TAB alebo dolnou šípkou. Presunte sa k predchádzajúcej možnosti s SHIFT + TAB alebo hornou šípkou. Stlačte medzerník alebo ENTER pre výber možnosti menu. Otvorte pod-menu danej možnosti s medzerníkom, alebo ENTER, alebo pravou šípkou. Vráťte sa späť do položky rodičovského menu s ESC alebo ľavou šípkou. Zatvorte kontextové menu s ESC."
   },
   {
    name: "Editorov box zoznamu",
    legend: "V boxe zoznamu, presuňte sa na ďalšiu položku v zozname s TAB alebo dolnou šípkou. Presuňte sa k predchádzajúcej položke v zozname so SHIFT + TAB alebo hornou šípkou. Stlačte medzerník alebo ENTER pre výber možnosti zoznamu. Stlačte ESC pre zatvorenie boxu zoznamu."
   }, {
    name: "Editorove pásmo cesty prvku",
    legend: "Stlačte ${elementsPathFocus} pre navigovanie na pásmo cesty elementu. Presuňte sa na tlačidlo ďalšieho prvku s TAB alebo pravou šípkou. Presuňte sa k predchádzajúcemu tlačidlu s SHIFT + TAB alebo ľavou šípkou. Stlačte medzerník alebo ENTER pre výber prvku v editore."
   }]
 },
  {
   name: "Príkazy",
   items: [{name: "Vrátiť príkazy", legend: "Stlačte ${undo}"}, {
    name: "Nanovo vrátiť príkaz",
    legend: "Stlačte ${redo}"
   }, {name: "Príkaz na stučnenie", legend: "Stlačte ${bold}"}, {
    name: "Príkaz na kurzívu",
    legend: "Stlačte ${italic}"
   }, {name: "Príkaz na podčiarknutie", legend: "Stlačte ${underline}"}, {
    name: "Príkaz na odkaz",
    legend: "Stlačte ${link}"
   }, {
    name: "Príkaz na zbalenie lišty nástrojov",
    legend: "Stlačte ${toolbarCollapse}"
   }, {
    name: "Prejsť na predchádzajúcu zamerateľnú medzeru príkazu",
    legend: "Stlačte ${accessPreviousSpace} pre prístup na najbližšie nedosiahnuteľné zamerateľné medzery pred vsuvkuo. Napríklad: dve za sebou idúce horizontálne čiary. Opakujte kombináciu klávesov pre dosiahnutie vzdialených zamerateľných medzier."
   },
    {
     name: "Prejsť na ďalší ",
     legend: "Stlačte ${accessNextSpace} pre prístup na najbližšie nedosiahnuteľné zamerateľné medzery po vsuvke. Napríklad: dve za sebou idúce horizontálne čiary. Opakujte kombináciu klávesov pre dosiahnutie vzdialených zamerateľných medzier."
    }, {name: "Pomoc prístupnosti", legend: "Stlačte ${a11yHelp}"}]
  }],
 backspace: "Backspace",
 tab: "Tab",
 enter: "Enter",
 shift: "Shift",
 ctrl: "Ctrl",
 alt: "Alt",
 pause: "Pause",
 capslock: "Caps Lock",
 escape: "Escape",
 pageUp: "Page Up",
 pageDown: "Page Down",
 end: "End",
 home: "Home",
 leftArrow: "Left Arrow",
 upArrow: "Up Arrow",
 rightArrow: "Right Arrow",
 downArrow: "Down Arrow",
 insert: "Insert",
 "delete": "Delete",
 leftWindowKey: "Left Windows key",
 rightWindowKey: "Right Windows key",
 selectKey: "Select key",
 numpad0: "Numpad 0",
 numpad1: "Numpad 1",
 numpad2: "Numpad 2",
 numpad3: "Numpad 3",
 numpad4: "Numpad 4",
 numpad5: "Numpad 5",
 numpad6: "Numpad 6",
 numpad7: "Numpad 7",
 numpad8: "Numpad 8",
 numpad9: "Numpad 9",
 multiply: "Multiply",
 add: "Add",
 subtract: "Subtract",
 decimalPoint: "Decimal Point",
 divide: "Divide",
 f1: "F1",
 f2: "F2",
 f3: "F3",
 f4: "F4",
 f5: "F5",
 f6: "F6",
 f7: "F7",
 f8: "F8",
 f9: "F9",
 f10: "F10",
 f11: "F11",
 f12: "F12",
 numLock: "Num Lock",
 scrollLock: "Scroll Lock",
 semiColon: "Semicolon",
 equalSign: "Equal Sign",
 comma: "Comma",
 dash: "Dash",
 period: "Period",
 forwardSlash: "Forward Slash",
 graveAccent: "Grave Accent",
 openBracket: "Open Bracket",
 backSlash: "Backslash",
 closeBracket: "Close Bracket",
 singleQuote: "Single Quote"
});