(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/found/found-routing.module.ts":
/*!***********************************************!*\
  !*** ./src/app/found/found-routing.module.ts ***!
  \***********************************************/
/*! exports provided: FoundRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FoundRoutingModule", function() { return FoundRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _found_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./found.component */ "./src/app/found/found.component.ts");




var routes = [
    { path: 'found', component: _found_component__WEBPACK_IMPORTED_MODULE_3__["FoundComponent"] }
];
var FoundRoutingModule = /** @class */ (function () {
    function FoundRoutingModule() {
    }
    FoundRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], FoundRoutingModule);
    return FoundRoutingModule;
}());



/***/ }),

/***/ "./src/app/found/found.component.css":
/*!*******************************************!*\
  !*** ./src/app/found/found.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2ZvdW5kL2ZvdW5kLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/found/found.component.html":
/*!********************************************!*\
  !*** ./src/app/found/found.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  found works!\n</p>\n"

/***/ }),

/***/ "./src/app/found/found.component.ts":
/*!******************************************!*\
  !*** ./src/app/found/found.component.ts ***!
  \******************************************/
/*! exports provided: FoundComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FoundComponent", function() { return FoundComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var FoundComponent = /** @class */ (function () {
    function FoundComponent() {
    }
    FoundComponent.prototype.ngOnInit = function () {
    };
    FoundComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-found',
            template: __webpack_require__(/*! ./found.component.html */ "./src/app/found/found.component.html"),
            styles: [__webpack_require__(/*! ./found.component.css */ "./src/app/found/found.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FoundComponent);
    return FoundComponent;
}());



/***/ }),

/***/ "./src/app/found/found.module.ts":
/*!***************************************!*\
  !*** ./src/app/found/found.module.ts ***!
  \***************************************/
/*! exports provided: FoundModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FoundModule", function() { return FoundModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _found_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./found.component */ "./src/app/found/found.component.ts");
/* harmony import */ var _found_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./found-routing.module */ "./src/app/found/found-routing.module.ts");





var FoundModule = /** @class */ (function () {
    function FoundModule() {
    }
    FoundModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [_found_component__WEBPACK_IMPORTED_MODULE_3__["FoundComponent"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _found_routing_module__WEBPACK_IMPORTED_MODULE_4__["FoundRoutingModule"]]
        })
    ], FoundModule);
    return FoundModule;
}());



/***/ }),

/***/ "./src/app/gotcha.app-routing.module.ts":
/*!**********************************************!*\
  !*** ./src/app/gotcha.app-routing.module.ts ***!
  \**********************************************/
/*! exports provided: GotchaAppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GotchaAppRoutingModule", function() { return GotchaAppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _gotcha_app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./gotcha.app.component */ "./src/app/gotcha.app.component.ts");




var routes = [
    { path: '', component: _gotcha_app_component__WEBPACK_IMPORTED_MODULE_3__["GotchaAppComponent"] },
    { path: '**', component: _gotcha_app_component__WEBPACK_IMPORTED_MODULE_3__["GotchaAppComponent"] }
];
var GotchaAppRoutingModule = /** @class */ (function () {
    function GotchaAppRoutingModule() {
    }
    GotchaAppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes, { enableTracing: true })],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], GotchaAppRoutingModule);
    return GotchaAppRoutingModule;
}());



/***/ }),

/***/ "./src/app/gotcha.app.component.css":
/*!******************************************!*\
  !*** ./src/app/gotcha.app.component.css ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2dvdGNoYS5hcHAuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/gotcha.app.component.html":
/*!*******************************************!*\
  !*** ./src/app/gotcha.app.component.html ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-header></app-header>\n<router-outlet></router-outlet>\n<app-footer></app-footer>\n"

/***/ }),

/***/ "./src/app/gotcha.app.component.ts":
/*!*****************************************!*\
  !*** ./src/app/gotcha.app.component.ts ***!
  \*****************************************/
/*! exports provided: GotchaAppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GotchaAppComponent", function() { return GotchaAppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var GotchaAppComponent = /** @class */ (function () {
    function GotchaAppComponent() {
        this.appName = 'Gotcha';
    }
    GotchaAppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'gotcha-app-root',
            template: __webpack_require__(/*! ./gotcha.app.component.html */ "./src/app/gotcha.app.component.html"),
            styles: [__webpack_require__(/*! ./gotcha.app.component.css */ "./src/app/gotcha.app.component.css")]
        })
    ], GotchaAppComponent);
    return GotchaAppComponent;
}());



/***/ }),

/***/ "./src/app/gotcha.app.module.ts":
/*!**************************************!*\
  !*** ./src/app/gotcha.app.module.ts ***!
  \**************************************/
/*! exports provided: GotchaAppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GotchaAppModule", function() { return GotchaAppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _shared_Shared_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./shared/Shared.module */ "./src/app/shared/Shared.module.ts");
/* harmony import */ var _gotcha_app_routing_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./gotcha.app-routing.module */ "./src/app/gotcha.app-routing.module.ts");
/* harmony import */ var _found_found_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./found/found.module */ "./src/app/found/found.module.ts");
/* harmony import */ var _missing_missing_module__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./missing/missing.module */ "./src/app/missing/missing.module.ts");
/* harmony import */ var _gotcha_app_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./gotcha.app.component */ "./src/app/gotcha.app.component.ts");










var GotchaAppModule = /** @class */ (function () {
    function GotchaAppModule() {
    }
    GotchaAppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [_gotcha_app_component__WEBPACK_IMPORTED_MODULE_9__["GotchaAppComponent"]],
            imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"], _shared_Shared_module__WEBPACK_IMPORTED_MODULE_5__["SharedModule"], _gotcha_app_routing_module__WEBPACK_IMPORTED_MODULE_6__["GotchaAppRoutingModule"], _found_found_module__WEBPACK_IMPORTED_MODULE_7__["FoundModule"], _missing_missing_module__WEBPACK_IMPORTED_MODULE_8__["MissingModule"]],
            providers: [],
            bootstrap: [_gotcha_app_component__WEBPACK_IMPORTED_MODULE_9__["GotchaAppComponent"]]
        })
    ], GotchaAppModule);
    return GotchaAppModule;
}());



/***/ }),

/***/ "./src/app/missing/missing-routing.module.ts":
/*!***************************************************!*\
  !*** ./src/app/missing/missing-routing.module.ts ***!
  \***************************************************/
/*! exports provided: MissingRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MissingRoutingModule", function() { return MissingRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _missing_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./missing.component */ "./src/app/missing/missing.component.ts");




var routes = [
    { path: 'missing', component: _missing_component__WEBPACK_IMPORTED_MODULE_3__["MissingComponent"] }
];
var MissingRoutingModule = /** @class */ (function () {
    function MissingRoutingModule() {
    }
    MissingRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], MissingRoutingModule);
    return MissingRoutingModule;
}());



/***/ }),

/***/ "./src/app/missing/missing.component.css":
/*!***********************************************!*\
  !*** ./src/app/missing/missing.component.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21pc3NpbmcvbWlzc2luZy5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/missing/missing.component.html":
/*!************************************************!*\
  !*** ./src/app/missing/missing.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  missing works!\n</p>\n"

/***/ }),

/***/ "./src/app/missing/missing.component.ts":
/*!**********************************************!*\
  !*** ./src/app/missing/missing.component.ts ***!
  \**********************************************/
/*! exports provided: MissingComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MissingComponent", function() { return MissingComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var MissingComponent = /** @class */ (function () {
    function MissingComponent() {
    }
    MissingComponent.prototype.ngOnInit = function () {
    };
    MissingComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-missing',
            template: __webpack_require__(/*! ./missing.component.html */ "./src/app/missing/missing.component.html"),
            styles: [__webpack_require__(/*! ./missing.component.css */ "./src/app/missing/missing.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], MissingComponent);
    return MissingComponent;
}());



/***/ }),

/***/ "./src/app/missing/missing.module.ts":
/*!*******************************************!*\
  !*** ./src/app/missing/missing.module.ts ***!
  \*******************************************/
/*! exports provided: MissingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MissingModule", function() { return MissingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _missing_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./missing.component */ "./src/app/missing/missing.component.ts");
/* harmony import */ var _missing_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./missing-routing.module */ "./src/app/missing/missing-routing.module.ts");





var MissingModule = /** @class */ (function () {
    function MissingModule() {
    }
    MissingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [_missing_component__WEBPACK_IMPORTED_MODULE_3__["MissingComponent"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _missing_routing_module__WEBPACK_IMPORTED_MODULE_4__["MissingRoutingModule"]]
        })
    ], MissingModule);
    return MissingModule;
}());



/***/ }),

/***/ "./src/app/shared/Shared.module.ts":
/*!*****************************************!*\
  !*** ./src/app/shared/Shared.module.ts ***!
  \*****************************************/
/*! exports provided: SharedModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SharedModule", function() { return SharedModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _shared_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./shared-routing.module */ "./src/app/shared/shared-routing.module.ts");
/* harmony import */ var _components_components_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/components.module */ "./src/app/shared/components/components.module.ts");






var SharedModule = /** @class */ (function () {
    function SharedModule() {
    }
    SharedModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"], _shared_routing_module__WEBPACK_IMPORTED_MODULE_4__["SharedRoutingModule"], _components_components_module__WEBPACK_IMPORTED_MODULE_5__["ComponentsModule"]]
        })
    ], SharedModule);
    return SharedModule;
}());



/***/ }),

/***/ "./src/app/shared/components/about-us/about-us.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/shared/components/about-us/about-us.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3NoYXJlZC9jb21wb25lbnRzL2Fib3V0LXVzL2Fib3V0LXVzLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/shared/components/about-us/about-us.component.html":
/*!********************************************************************!*\
  !*** ./src/app/shared/components/about-us/about-us.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <article><!--main content start -->\n  <div class=\"row\">\n      <div class=\"col-md-12\">\n      <div class=\"card\">\n        <div class=\"card-header bg-dark text-center\">\n          <span class=\"card-img-top fa fa-globe text-success my-auto\" style=\"font-size:40px\">&nbsp;&nbsp;About Us</span></div>\n      <div class=\"card-body\">\n     <div readonly class=\"form-control-plaintext\">\n <p>Imagine was you removal raising gravity. Unsatiable understood or expression dissimilar so sufficient. Its party every heard and event gay. Advice he indeed things adieus in number so uneasy. To many four fact in he fail. My hung it quit next do of. It fifteen charmed by private savings it mr. Favourable cultivated alteration entreaties yet met sympathize. Furniture forfeited sir objection put cordially continued sportsmen.\n</p><p>Up branch to easily missed by do. Admiration considered acceptance too led one melancholy expression. Are will took form the nor true. Winding enjoyed minuter her letters evident use eat colonel. He attacks observe mr cottage inquiry am examine gravity. Are dear but near left was. Year kept on over so as this of. She steepest doubtful betrayed formerly him. Active one called uneasy our seeing see cousin tastes its. Ye am it formed indeed agreed relied piqued.</p><p>\nAble an hope of body. Any nay shyness article matters own removal nothing his forming. Gay own additions education satisfied the perpetual. If he cause manor happy. Without farther she exposed saw man led. Along on happy could cease green oh.</p><p>\nOught these are balls place mrs their times add she. Taken no great widow spoke of it small. Genius use except son esteem merely her limits. Sons park by do make on. It do oh cottage offered cottage in written. Especially of dissimilar up attachment themselves by interested boisterous. Linen mrs seems men table. Jennings dashwood to quitting marriage bachelor in. On as conviction in of appearance apartments boisterous.</p><p>\nAdmiration we surrounded possession frequently he. Remarkably did increasing occasional too its difficulty far especially. Known tiled but sorry joy balls. Bed sudden manner indeed fat now feebly. Face do with in need of wife paid that be. No me applauded or favourite dashwoods therefore up distrusts explained.</p><p>\nFar quitting dwelling graceful the likewise received building. An fact so to that show am shed sold cold. Unaffected remarkably get yet introduced excellence terminated led. Result either design saw she esteem and. On ashamed no inhabit ferrars it ye besides resolve. Own judgment directly few trifling. Elderly as pursuit at regular do parlors. Rank what has into fond she.</p><p>\nOf be talent me answer do relied. Mistress in on so laughing throwing endeavor occasion welcomed. Gravity sir brandon calling can. No years do widow house delay stand. Prospect six kindness use steepest new ask. High gone kind calm call as ever is. Introduced melancholy estimating motionless on up as do. Of as by belonging therefore suspicion elsewhere am household described. Domestic suitable bachelor for landlord fat.</p><p>\nNow led tedious shy lasting females off. Dashwood marianne in of entrance be on wondered possible building. Wondered sociable he carriage in speedily margaret. Up devonshire of he thoroughly insensible alteration. An mr settling occasion insisted distance ladyship so. Not attention say frankness intention out dashwoods now curiosity. Stronger ecstatic as no judgment daughter speedily thoughts. Worse downs nor might she court did nay forth these.</p>\n      </div>\n    </div>\n    </div>\n  </div>"

/***/ }),

/***/ "./src/app/shared/components/about-us/about-us.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/shared/components/about-us/about-us.component.ts ***!
  \******************************************************************/
/*! exports provided: AboutUsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutUsComponent", function() { return AboutUsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AboutUsComponent = /** @class */ (function () {
    function AboutUsComponent() {
    }
    AboutUsComponent.prototype.ngOnInit = function () {
    };
    AboutUsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-about-us',
            template: __webpack_require__(/*! ./about-us.component.html */ "./src/app/shared/components/about-us/about-us.component.html"),
            styles: [__webpack_require__(/*! ./about-us.component.css */ "./src/app/shared/components/about-us/about-us.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AboutUsComponent);
    return AboutUsComponent;
}());



/***/ }),

/***/ "./src/app/shared/components/components.module.ts":
/*!********************************************************!*\
  !*** ./src/app/shared/components/components.module.ts ***!
  \********************************************************/
/*! exports provided: ComponentsModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ComponentsModule", function() { return ComponentsModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./header/header.component */ "./src/app/shared/components/header/header.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/shared/components/footer/footer.component.ts");
/* harmony import */ var _faq_faq_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./faq/faq.component */ "./src/app/shared/components/faq/faq.component.ts");
/* harmony import */ var _contact_us_contact_us_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./contact-us/contact-us.component */ "./src/app/shared/components/contact-us/contact-us.component.ts");
/* harmony import */ var _about_us_about_us_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./about-us/about-us.component */ "./src/app/shared/components/about-us/about-us.component.ts");









var ComponentsModule = /** @class */ (function () {
    function ComponentsModule() {
    }
    ComponentsModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [_about_us_about_us_component__WEBPACK_IMPORTED_MODULE_8__["AboutUsComponent"], _contact_us_contact_us_component__WEBPACK_IMPORTED_MODULE_7__["ContactUsComponent"], _faq_faq_component__WEBPACK_IMPORTED_MODULE_6__["FaqComponent"], _footer_footer_component__WEBPACK_IMPORTED_MODULE_5__["FooterComponent"], _header_header_component__WEBPACK_IMPORTED_MODULE_4__["HeaderComponent"]],
            exports: [_about_us_about_us_component__WEBPACK_IMPORTED_MODULE_8__["AboutUsComponent"], _contact_us_contact_us_component__WEBPACK_IMPORTED_MODULE_7__["ContactUsComponent"], _faq_faq_component__WEBPACK_IMPORTED_MODULE_6__["FaqComponent"], _footer_footer_component__WEBPACK_IMPORTED_MODULE_5__["FooterComponent"], _header_header_component__WEBPACK_IMPORTED_MODULE_4__["HeaderComponent"]],
            imports: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"]]
        })
    ], ComponentsModule);
    return ComponentsModule;
}());



/***/ }),

/***/ "./src/app/shared/components/contact-us/contact-us.component.css":
/*!***********************************************************************!*\
  !*** ./src/app/shared/components/contact-us/contact-us.component.css ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3NoYXJlZC9jb21wb25lbnRzL2NvbnRhY3QtdXMvY29udGFjdC11cy5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/shared/components/contact-us/contact-us.component.html":
/*!************************************************************************!*\
  !*** ./src/app/shared/components/contact-us/contact-us.component.html ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-3 container\">\n  <div class=\"card\">\n          <div class=\"card-header bg-dark text-center\">\n      <span class=\"card-img-top fa fa-quote-right text-success my-auto\" style=\"font-size:40px\">&nbsp;&nbsp;Contact Us</span>\n      </div>\n       <div class=\"card-body\">\n          <form action=\"/#\">\n          <div class=\"form-group\">\n            <label for=\"contactUsFormName\">Your Name</label>\n            <input type=\"text\" id=\"contactUsFormName\" class=\"form-control\" placeholder=\"Enter your name\" required>\n          </div>\n          <div class=\"form-group\">\n            <label for=\"contactUsFormEmail\">E-mail</label>\n            <input type=\"email\" id=\"contactUsFormEmail\" class=\"form-control\" placeholder=\"Enter email\" required>\n          </div>\n          <div class=\"form-group\">\n            <label for=\"contactUsFormContactNumber\">Contact Number</label>\n            <input type=\"number\" id=\"contactUsFormContactNumber\" class=\"form-control\" required>\n          </div>\n            <div class=\"form-group\">\n                <label for=\"contactUsFormMessage\">Message</label>\n              <textarea class=\"form-control rounded-0\" id=\"contactUsFormMessage\" rows=\"3\" placeholder=\"Message\"></textarea>\n          </div>\n\n          <div class=\"form-group\">\n                <div class=\"custom-control custom-checkbox\">\n        <input type=\"checkbox\" class=\"custom-control-input\" id=\"defaultContactFormCopy\">\n        <label class=\"custom-control-label\" for=\"defaultContactFormCopy\">Send me a copy of this message</label>\n       </div>\n            <button class=\"btn btn-info btn-block my-3\" type=\"submit\">Send</button>\n            <p class=\"form-text text-muted\" href=\"#\"><small>Our toll free number 1800-00-000</small></p>\n            \n          </div>\n        </form>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/shared/components/contact-us/contact-us.component.ts":
/*!**********************************************************************!*\
  !*** ./src/app/shared/components/contact-us/contact-us.component.ts ***!
  \**********************************************************************/
/*! exports provided: ContactUsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ContactUsComponent", function() { return ContactUsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var ContactUsComponent = /** @class */ (function () {
    function ContactUsComponent() {
    }
    ContactUsComponent.prototype.ngOnInit = function () {
    };
    ContactUsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-contact-us',
            template: __webpack_require__(/*! ./contact-us.component.html */ "./src/app/shared/components/contact-us/contact-us.component.html"),
            styles: [__webpack_require__(/*! ./contact-us.component.css */ "./src/app/shared/components/contact-us/contact-us.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], ContactUsComponent);
    return ContactUsComponent;
}());



/***/ }),

/***/ "./src/app/shared/components/faq/faq.component.css":
/*!*********************************************************!*\
  !*** ./src/app/shared/components/faq/faq.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3NoYXJlZC9jb21wb25lbnRzL2ZhcS9mYXEuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/shared/components/faq/faq.component.html":
/*!**********************************************************!*\
  !*** ./src/app/shared/components/faq/faq.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n  <div class=\"col-md-8 container\">\n    <div class=\"card\">\n\n      <div class=\"card-header bg-dark text-center\">\n        <span class=\"card-img-top fa fa-quote-right text-success my-auto\" style=\"font-size:40px\">&nbsp;&nbsp;Frequently Asked Question</span>\n      </div>\n      \n      <div class=\"card-body\">\n    <!--Accordion wrapper-->\n    <div class=\"accordion\" id=\"accordionFaq\" aria-multiselectable=\"true\">\n      \n      <!-- Accordion card start-->\n      <div class=\"card\">\n        <div class=\"card-header\" id=\"question1\">\n          <h5 class=\"mb-0\">\n            <button class=\"btn btn-link\" data-toggle=\"collapse\" data-target=\"#collapseQuestion1\" aria-expanded=\"true\" aria-controls=\"collapseQuestion1\">\n    What is eDOC ?\n  </button>\n</h5>\n</div>\n<div id=\"collapseQuestion1\" class=\"collapse\" aria-labelledby=\"question1\" data-parent=\"#accordionFaq\">\n<div class=\"card-body\">\n<p>eDOC is a online document management system.</p>\n</div>\n</div>\n</div> <!-- Accordion card end-->\n\n<!-- Accordion card start-->\n<div class=\"card\">\n<div class=\"card-header\" id=\"question2\">\n<h5 class=\"mb-0\">\n  <button class=\"btn btn-link\" data-toggle=\"collapse\" data-target=\"#collapseQuestion2\" aria-expanded=\"false\" aria-controls=\"collapseQuestion2\">How to upload my document in eDoc?\n  </button>\n</h5>\n</div>\n<div id=\"collapseQuestion2\" class=\"collapse show\" aria-labelledby=\"question2\" data-parent=\"#accordionFaq\">\n<div class=\"card-body\">\n  <p>See the document upload section. Press the upload button, after that you need to browse the file to upload. then press the submit button.</p>\n</div>\n</div>\n</div> <!-- Accordion card end-->\n\n<!-- Accordion card start-->\n<div class=\"card\">\n<div class=\"card-header\" id=\"question3\">\n<h5 class=\"mb-0\">\n  <button class=\"btn btn-link\" data-toggle=\"collapse\" data-target=\"#collapseQuestion3\" aria-expanded=\"false\" aria-controls=\"collapseQuestion3\">How to download my document in eDoc?\n  </button>\n</h5>\n</div>\n<div id=\"collapseQuestion3\" class=\"collapse\" aria-labelledby=\"question3\" data-parent=\"#accordionFaq\">\n<div class=\"card-body\">\n  <p>See the uploaded document view select the document and click download button.</p>\n</div>\n</div>\n</div> <!-- Accordion card end-->\n\n</div>\n<!--/.Accordion wrapper-->\n</div>\n</div>\n</div>\n</div>"

/***/ }),

/***/ "./src/app/shared/components/faq/faq.component.ts":
/*!********************************************************!*\
  !*** ./src/app/shared/components/faq/faq.component.ts ***!
  \********************************************************/
/*! exports provided: FaqComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FaqComponent", function() { return FaqComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var FaqComponent = /** @class */ (function () {
    function FaqComponent() {
    }
    FaqComponent.prototype.ngOnInit = function () {
    };
    FaqComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-faq',
            template: __webpack_require__(/*! ./faq.component.html */ "./src/app/shared/components/faq/faq.component.html"),
            styles: [__webpack_require__(/*! ./faq.component.css */ "./src/app/shared/components/faq/faq.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FaqComponent);
    return FaqComponent;
}());



/***/ }),

/***/ "./src/app/shared/components/footer/footer.component.css":
/*!***************************************************************!*\
  !*** ./src/app/shared/components/footer/footer.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3NoYXJlZC9jb21wb25lbnRzL2Zvb3Rlci9mb290ZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/shared/components/footer/footer.component.html":
/*!****************************************************************!*\
  !*** ./src/app/shared/components/footer/footer.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "footer Works"

/***/ }),

/***/ "./src/app/shared/components/footer/footer.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/shared/components/footer/footer.component.ts ***!
  \**************************************************************/
/*! exports provided: FooterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterComponent", function() { return FooterComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var FooterComponent = /** @class */ (function () {
    function FooterComponent() {
    }
    FooterComponent.prototype.ngOnInit = function () {
    };
    FooterComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-footer',
            template: __webpack_require__(/*! ./footer.component.html */ "./src/app/shared/components/footer/footer.component.html"),
            styles: [__webpack_require__(/*! ./footer.component.css */ "./src/app/shared/components/footer/footer.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FooterComponent);
    return FooterComponent;
}());



/***/ }),

/***/ "./src/app/shared/components/header/header.component.css":
/*!***************************************************************!*\
  !*** ./src/app/shared/components/header/header.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3NoYXJlZC9jb21wb25lbnRzL2hlYWRlci9oZWFkZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/shared/components/header/header.component.html":
/*!****************************************************************!*\
  !*** ./src/app/shared/components/header/header.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "Header Works"

/***/ }),

/***/ "./src/app/shared/components/header/header.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/shared/components/header/header.component.ts ***!
  \**************************************************************/
/*! exports provided: HeaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HeaderComponent", function() { return HeaderComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var HeaderComponent = /** @class */ (function () {
    function HeaderComponent() {
        this.appName = "gotchaaaaaaaaaaaaaaaa";
    }
    HeaderComponent.prototype.ngOnInit = function () {
    };
    HeaderComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-header',
            template: __webpack_require__(/*! ./header.component.html */ "./src/app/shared/components/header/header.component.html"),
            styles: [__webpack_require__(/*! ./header.component.css */ "./src/app/shared/components/header/header.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], HeaderComponent);
    return HeaderComponent;
}());



/***/ }),

/***/ "./src/app/shared/shared-routing.module.ts":
/*!*************************************************!*\
  !*** ./src/app/shared/shared-routing.module.ts ***!
  \*************************************************/
/*! exports provided: SharedRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SharedRoutingModule", function() { return SharedRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _components_faq_faq_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/faq/faq.component */ "./src/app/shared/components/faq/faq.component.ts");
/* harmony import */ var _components_contact_us_contact_us_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/contact-us/contact-us.component */ "./src/app/shared/components/contact-us/contact-us.component.ts");
/* harmony import */ var _components_about_us_about_us_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/about-us/about-us.component */ "./src/app/shared/components/about-us/about-us.component.ts");






var routes = [
    {
        path: 'about-us',
        component: _components_about_us_about_us_component__WEBPACK_IMPORTED_MODULE_5__["AboutUsComponent"]
    },
    {
        path: 'contact-us',
        component: _components_contact_us_contact_us_component__WEBPACK_IMPORTED_MODULE_4__["ContactUsComponent"]
    },
    {
        path: 'faq',
        component: _components_faq_faq_component__WEBPACK_IMPORTED_MODULE_3__["FaqComponent"]
    }
];
var SharedRoutingModule = /** @class */ (function () {
    function SharedRoutingModule() {
    }
    SharedRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], SharedRoutingModule);
    return SharedRoutingModule;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_gotcha_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/gotcha.app.module */ "./src/app/gotcha.app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_gotcha_app_module__WEBPACK_IMPORTED_MODULE_2__["GotchaAppModule"]).then(function (ref) {
    // Ensure Angular destroys itself on hot reloads.
    if (window['ngRef']) {
        window['ngRef'].destroy();
    }
    window['ngRef'] = ref;
    // Otherwise, log the boot error
}).catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! D:\projects\angular\gotcha\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map