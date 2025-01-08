import { Pipe, PipeTransform, SecurityContext } from "@angular/core";
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { Injectable } from '@angular/core';
@Pipe({
    name: 'safeHtml'
})
@Injectable()
export class SecuritypipeService implements PipeTransform {

    constructor(private sanitizer: DomSanitizer) {}

    transform (value: string): SafeHtml {
        return this.sanitizer.bypassSecurityTrustHtml(value);
    }
}