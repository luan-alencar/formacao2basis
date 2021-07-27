import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { CommonModule } from '@angular/common';
import { ServiceModule } from './services/service-module.service';
@NgModule({
    imports: [
        PRIMENG_IMPORTS,
        CommonModule,
        ServiceModule
    ],
    exports: [
        PRIMENG_IMPORTS,
        CommonModule,
        ServiceModule
    ],
})
export class SharedModule { }

